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

public class CauldronBottleProcedure {
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
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.GLASS_BOTTLE, (int) (1)).getItem())) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == FireCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:fire_resistance\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == HarmingCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:harming\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == HealingCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:healing\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == InvisibleCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:invisibility\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == JumpingCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:leaping\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NightCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:night_vision\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PoisonCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:poison\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == RegenCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:regeneration\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SlownessCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:slowness\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SpeedCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:swiftness\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SlowfallCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:slow_falling\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == StrengthCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:strength\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WaterCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:water_breathing\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WeaknessCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion{Potion:\"minecraft:weakness\"} 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AwkwardCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"give @s potion 1");
					}
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			}
		}
        if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.BUCKET, (int) (1)).getItem())) {
            if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == LavaCauldronBlock.block.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.CAULDRON.getDefaultState(), 3);
				{
					Entity _ent = entity;
                    if (entity instanceof PlayerEntity) {
                        ItemStack _setstack = new ItemStack(Items.LAVA_BUCKET);
                        _setstack.setCount((int) 1);
                        ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
                    }
				}
                (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
			} 
        }
	}
}
