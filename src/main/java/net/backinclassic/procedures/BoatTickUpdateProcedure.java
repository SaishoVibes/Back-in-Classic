package net.backinclassic.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class BoatTickUpdateProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure BoatTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure BoatTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure BoatTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure BoatTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure BoatTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((Math.abs((entity.getMotion().getX())) >= 0.075) || (Math.abs((entity.getMotion().getZ())) >= 0.075))) {
			if (((!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.WATER))
					|| (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.WATER)))) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
			}
			if (((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER))
					|| (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.WATER)))) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
			}
		}
		sx = (double) (-3);
		found = (boolean) (false);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			sy = (double) (-3);
			for (int index1 = 0; index1 < (int) (6); index1++) {
				sz = (double) (-3);
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if (((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() == Blocks.WATER)) {
						found = (boolean) (true);
					}
					sz = (double) (sz + 1);
				}
				sy = (double) (sy + 1);
			}
			sx = (double) (sx + 1);
		}
		if ((found == (false))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
		}
	}
}
