package net.backinclassic.procedures.nether_reactor;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.backinclassic.BackInClassicMod;

import java.util.Map;
import java.util.HashMap;

public class NetherReactorInit {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure NetherReactorCoreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure NetherReactorCoreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure NetherReactorCoreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure NetherReactorCoreOnBlockRightClicked!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean UpperCheck = false;
		boolean LowerCheck = false;
		UpperCheck = (boolean) (false);
		if ((((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 1)))).getBlock() == Blocks.COBBLESTONE)
				&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z - 1)))).getBlock() == Blocks.COBBLESTONE))
				&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z - 1)))).getBlock() == Blocks.COBBLESTONE)
						&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 1)))).getBlock() == Blocks.COBBLESTONE)))
				&& ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 0)))).getBlock() == Blocks.COBBLESTONE)
						&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)))).getBlock() == Blocks.COBBLESTONE))
						&& (((world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.COBBLESTONE)
								&& ((world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 1), (int) (z - 1))))
										.getBlock() == Blocks.COBBLESTONE))))) {
			UpperCheck = (boolean) (true);
		}
		LowerCheck = (boolean) (false);
		if ((((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.GOLD_BLOCK)
				&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.GOLD_BLOCK))
				&& (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.GOLD_BLOCK)
						&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.GOLD_BLOCK)))
				&& ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) (z + 0)))).getBlock() == Blocks.COBBLESTONE)
						&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z + 0)))).getBlock() == Blocks.COBBLESTONE))
						&& (((world.getBlockState(new BlockPos((int) (x - 0), (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.COBBLESTONE)
								&& ((world.getBlockState(new BlockPos((int) (x - 0), (int) (y - 1), (int) (z - 1))))
										.getBlock() == Blocks.COBBLESTONE))))) {
			LowerCheck = (boolean) (true);
		}
		if ((((UpperCheck == (true)) && (LowerCheck == (true)))
				&& ((world.getBlockState(new BlockPos((int) (x - 0), (int) (y - 1), (int) (z - 0)))).getBlock() == Blocks.COBBLESTONE)
                && ((world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 1), (int) (z - 0)))).getBlock() == Blocks.AIR))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("world", world);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				NetherReaction.executeProcedure($_dependencies);
			}
		}
	}
}
