package net.mcreator.backinclassic.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.Blocks;

import net.mcreator.backinclassic.BackInClassicMod;

import java.util.Map;

public class NetherPortalCreatorRightClickedOnBlockProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure NetherPortalCreatorRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure NetherPortalCreatorRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure NetherPortalCreatorRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure NetherPortalCreatorRightClickedOnBlock!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"fill ~ ~1 ~ ~3 ~5 ~ air destroy ");
		}
		if (((true) == (true))) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 1), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 1), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
		}
		if (((true) == (true))) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 5), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 5), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 5), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
		}
		if (((true) == (true))) {
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 4), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 3), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 0), (int) (y + 2), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
		}
		if (((true) == (true))) {
			world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 4), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 3), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 2), (int) (z + 0)), Blocks.OBSIDIAN.getDefaultState(), 3);
		}
		if (((true) == (true))) {
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 4), (int) (z + 0)), Blocks.NETHER_PORTAL.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 3), (int) (z + 0)), Blocks.NETHER_PORTAL.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 2), (int) (z + 0)), Blocks.NETHER_PORTAL.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 4), (int) (z + 0)), Blocks.NETHER_PORTAL.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 3), (int) (z + 0)), Blocks.NETHER_PORTAL.getDefaultState(), 3);
			world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 2), (int) (z + 0)), Blocks.NETHER_PORTAL.getDefaultState(), 3);
		}
	}
}
