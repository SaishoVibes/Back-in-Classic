package net.backinclassic.reach;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.backinclassic.BackInClassicModElements;
import net.backinclassic.BackInClassicMod;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceContext;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
//import vazkii.quark.base.Quark;
import net.backinclassic.reach.RayTraceHandler;
//import net.backinclassic.reach.module.LoadModule;
//import vazkii.quark.base.module.ModuleCategory;
//import vazkii.quark.base.module.QuarkModule;
import net.backinclassic.reach.module.Config;

//@LoadModule(category = ModuleCategory.TWEAKS, hasSubscriptions = true)
public class ReacharoundPlacingModule extends BackInClassicModElements.ModElement {

	@Config
	@Config.Min(0)
	@Config.Max(1)
	public double leniency = 0.5;

	@Config
	public List<String> whitelist = Lists.newArrayList();

	@Config
	public String display = "[  ]";

	@Config
	public String displayHorizontal = "<  >";

	private ReacharoundTarget currentTarget;
	private int ticksDisplayed;

	public static Tag<Item> reacharoundTag;

	@Override
	public void setup() {
		reacharoundTag = ItemTags.createOptional(new ResourceLocation(BackInClassicMod.MOD_ID, "reacharound_able"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onRender(RenderGameOverlayEvent.Pre event) {
		if(event.getType() != RenderGameOverlayEvent.ElementType.ALL)
			return;

		Minecraft mc = Minecraft.getInstance();
		Player player = mc.player;

		if(player != null && currentTarget != null) {
			Window res = event.getWindow();
			PoseStack matrix = event.getMatrixStack();
			String text = (currentTarget.dir.getAxis() == Axis.Y ? display : displayHorizontal);

			matrix.pushPose();
			matrix.translate(res.getGuiScaledWidth() / 2F, res.getGuiScaledHeight() / 2f - 4, 0);

			float scale = Math.min(5, ticksDisplayed + event.getPartialTicks()) / 5F;
			scale *= scale;
			int opacity = ((int) (255 * scale)) << 24;

			matrix.scale(scale, 1F, 1F);
			matrix.translate(-mc.font.width(text) / 2f, 0, 0);
			mc.font.draw(matrix, text, 0, 0, 0xFFFFFF | opacity);
			matrix.popPose();
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void clientTick(ClientTickEvent event) {
		if(event.phase == Phase.END) {
			currentTarget = null;

			Player player = Minecraft.getInstance().player;
			if(player != null)
				currentTarget = getPlayerReacharoundTarget(player);

			if(currentTarget != null) {
				if(ticksDisplayed < 5)
					ticksDisplayed++;
			} else ticksDisplayed = 0;
		}
	}

	@SubscribeEvent
	public void onRightClick(PlayerInteractEvent.RightClickItem event) {
		Player player = event.getPlayer();
		ReacharoundTarget target = getPlayerReacharoundTarget(player);

		if(target != null && event.getHand() == target.hand) {
			ItemStack stack = event.getItemStack();
			if(!player.mayUseItemAt(target.pos, target.dir, stack))
				return;
			
			int count = stack.getCount();
			InteractionHand hand = event.getHand();

			UseOnContext context = new UseOnContext(player, hand, new BlockHitResult(new Vec3(0.5F, 1F, 0.5F), target.dir, target.pos, false));
			boolean remote = player.level.isClientSide;
			Item item = stack.getItem();
			InteractionResult res = remote ? InteractionResult.SUCCESS : item.useOn(context);

			if (res != InteractionResult.PASS) {
				event.setCanceled(true);
				event.setCancellationResult(res);

				if(res == InteractionResult.SUCCESS)
					player.swing(hand);
				else if(res == InteractionResult.CONSUME) {
					BlockPos placedPos = target.pos;
					BlockState state = player.level.getBlockState(placedPos);
					SoundType soundtype = state.getSoundType(player.level, placedPos, context.getPlayer());

					if(player.level instanceof ServerLevel)
						((ServerLevel) player.level).playSound(null, placedPos, soundtype.getPlaceSound(), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

				}

				if(player.isCreative() && stack.getCount() < count && !remote)
					stack.setCount(count);
			}
		}
	}

	private ReacharoundTarget getPlayerReacharoundTarget(Player player) {
		InteractionHand hand = null;
		if(validateReacharoundStack(player.getMainHandItem()))
			hand = InteractionHand.MAIN_HAND;
		else if(validateReacharoundStack(player.getOffhandItem()))
			hand = InteractionHand.OFF_HAND;
		
		if(hand == null)
			return null;
			
		Level world = player.level;

		Pair<Vec3, Vec3> params = RayTraceHandler.getEntityParams(player);
		double range = RayTraceHandler.getEntityRange(player);
		Vec3 rayPos = params.getLeft();
		Vec3 ray = params.getRight().scale(range);

		HitResult normalRes = RayTraceHandler.rayTrace(player, world, rayPos, ray, Block.OUTLINE, Fluid.NONE);

		if (normalRes.getType() == HitResult.Type.MISS) {
			ReacharoundTarget  target = getPlayerVerticalReacharoundTarget(player, hand, world, rayPos, ray);
			if(target != null)
				return target;

			target = getPlayerHorizontalReacharoundTarget(player, hand, world, rayPos, ray);
			if(target != null)
				return target;
		}

		return null;
	}

	private ReacharoundTarget getPlayerVerticalReacharoundTarget(Player player, InteractionHand hand, Level world, Vec3 rayPos, Vec3 ray) {
		if(player.getXRot() < 0)
			return null;

		rayPos = rayPos.add(0, leniency, 0);
		HitResult take2Res = RayTraceHandler.rayTrace(player, world, rayPos, ray, Block.OUTLINE, Fluid.NONE);

		if (take2Res.getType() == HitResult.Type.BLOCK && take2Res instanceof BlockHitResult) {
			BlockPos pos = ((BlockHitResult) take2Res).getBlockPos().below();
			BlockState state = world.getBlockState(pos);

			if (player.position().y - pos.getY() > 1 && (world.isEmptyBlock(pos) || state.getMaterial().isReplaceable()))
				return new ReacharoundTarget(pos, Direction.DOWN, hand);
		}

		return null;
	}

	private ReacharoundTarget getPlayerHorizontalReacharoundTarget(Player player, InteractionHand hand, Level world, Vec3 rayPos, Vec3 ray) {
		Direction dir = Direction.fromYRot(player.getYRot());
		rayPos = rayPos.subtract(leniency * dir.getStepX(), 0, leniency * dir.getStepZ());
		HitResult take2Res = RayTraceHandler.rayTrace(player, world, rayPos, ray, Block.OUTLINE, Fluid.NONE);

		if (take2Res.getType() == HitResult.Type.BLOCK && take2Res instanceof BlockHitResult) {
			BlockPos pos = ((BlockHitResult) take2Res).getBlockPos().relative(dir);
			BlockState state = world.getBlockState(pos);

			if ((world.isEmptyBlock(pos) || state.getMaterial().isReplaceable()))
				return new ReacharoundTarget(pos, dir.getOpposite(), hand);
		}

		return null;
	}

	private boolean validateReacharoundStack(ItemStack stack) {
		Item item = stack.getItem();
		return item instanceof BlockItem || stack.is(reacharoundTag) || whitelist.contains(Objects.toString(item.getRegistryName()));
	}
	
	private static class ReacharoundTarget {
		
		final BlockPos pos;
		final Direction dir;
		final InteractionHand hand;
		
		public ReacharoundTarget(BlockPos pos, Direction dir, InteractionHand hand) {
			this.pos = pos;
			this.dir = dir;
			this.hand = hand;
		}
		
	}

}