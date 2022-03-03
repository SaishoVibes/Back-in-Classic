package net.backinclassic.procedures;

import net.backinclassic.BackInClassicMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Map;

public class CogwheelValueProcedure {
	public static double executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure CogwheelValue!");
			return 0;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure CogwheelValue!");
			return 0;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure CogwheelValue!");
			return 0;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure CogwheelValue!");
			return 0;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0))) : false)
				|| (((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0))) : false)
						|| ((world instanceof World)
								? ((World) world).isBlockPowered(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0)))
								: false)))
				|| (((world instanceof World) ? ((World) world).isBlockPowered(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0))) : false)
						|| (((world instanceof World)
								? ((World) world).isBlockPowered(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 1)))
								: false)
								|| ((world instanceof World)
										? ((World) world).isBlockPowered(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z - 1)))
										: false))))) {
			return 15;
		}
		return 0;
	}
}
