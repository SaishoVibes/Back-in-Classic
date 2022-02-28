package net.backinclassic.procedures.brewing;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;

import net.backinclassic.block.brewing.AwkwardCauldronBlock;
import net.backinclassic.block.brewing.SpeedCauldronBlock;
import net.backinclassic.block.brewing.JumpingCauldronBlock;
import net.backinclassic.block.brewing.SlownessCauldronBlock;
import net.backinclassic.block.brewing.HealingCauldronBlock;
import net.backinclassic.block.brewing.HarmingCauldronBlock;
import net.backinclassic.block.brewing.FireCauldronBlock;
import net.backinclassic.block.brewing.InvisibleCauldronBlock;
import net.backinclassic.block.brewing.NightCauldronBlock;
import net.backinclassic.block.brewing.PoisonCauldronBlock;
import net.backinclassic.block.brewing.RegenCauldronBlock;
import net.backinclassic.block.brewing.SlowfallCauldronBlock;
import net.backinclassic.block.brewing.StrengthCauldronBlock;
import net.backinclassic.block.brewing.WaterCauldronBlock;
import net.backinclassic.block.brewing.WeaknessCauldronBlock;
import net.backinclassic.block.brewing.LavaCauldronBlock;
import net.backinclassic.BackInClassicMod;

import java.util.Map;
import java.util.HashMap;

public class CauldronBrewingProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure Caultrontoawkward!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure Caultrontoawkward!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure Caultrontoawkward!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure Caultrontoawkward!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure Caultrontoawkward!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == new ItemStack(Items.NETHER_WART, (int) (1)).getItem())
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAULDRON))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), AwkwardCauldronBlock.block.getDefaultState(), 3);
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
            if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.SUGAR, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SpeedCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SpeedCauldronBlock.block.getDefaultState().getBlock()) || 
                ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == JumpingCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.FERMENTED_SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SlownessCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.RABBIT_FOOT, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), JumpingCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.BLAZE_POWDER, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), StrengthCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.GLISTERING_MELON_SLICE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), HealingCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PoisonCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PoisonCauldronBlock.block.getDefaultState().getBlock()) || 
                ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == HealingCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.FERMENTED_SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), HarmingCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.GHAST_TEAR, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RegenCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.MAGMA_CREAM, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), FireCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.PUFFERFISH, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WaterCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.GOLDEN_CARROT, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), NightCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NightCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.FERMENTED_SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), InvisibleCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.PHANTOM_MEMBRANE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PoisonCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.FERMENTED_SPIDER_EYE, (int) (1)).getItem())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), WeaknessCauldronBlock.block.getDefaultState(), 3);
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
                if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
			}
		}
        if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == new ItemStack(Items.LAVA_BUCKET, (int) (1)).getItem())
				&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CAULDRON))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), LavaCauldronBlock.block.getDefaultState(), 3);
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
            if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(
							(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getItem(),
							(int) 20);
            if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Items.BUCKET);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
