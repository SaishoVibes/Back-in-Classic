package net.backinclassic.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.backinclassic.world.DoInfiniteWaterGameRule;
import net.backinclassic.block.InfiniteLavaBlock;
import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class InfiniteLavaUpdateTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure InfiniteLavaUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure InfiniteLavaUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure InfiniteLavaUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure InfiniteLavaUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(DoInfiniteWaterGameRule.gamerule)) == (true))) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z + 0)))).getBlock() == Blocks.AIR)) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z + 0)), InfiniteLavaBlock.block.getDefaultState(), 3);
					}
					if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 0), (int) (z + 0)))).getBlock() == Blocks.AIR)) {
						world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 0), (int) (z + 0)), InfiniteLavaBlock.block.getDefaultState(), 3);
					}
					if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z + 1)))).getBlock() == Blocks.AIR)) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z + 1)), InfiniteLavaBlock.block.getDefaultState(), 3);
					}
					if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z - 1)))).getBlock() == Blocks.AIR)) {
						world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z - 1)), InfiniteLavaBlock.block.getDefaultState(), 3);
					}
					if (((world.getBlockState(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)))).getBlock() == Blocks.AIR)) {
						world.setBlockState(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)), InfiniteLavaBlock.block.getDefaultState(), 3);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 40);
		}
	}
}
