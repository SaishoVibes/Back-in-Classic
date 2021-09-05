package net.backinclassic.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class HumanNaturalEntityVillageConditionProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure HumanNaturalEntityVillageCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		boolean daytimeCheck = false;
		daytimeCheck = (boolean) (false);
		if ((!((world instanceof World) ? ((World) world).isDaytime() : false))) {
			daytimeCheck = (boolean) (true);
		}
		return daytimeCheck;
	}
}
