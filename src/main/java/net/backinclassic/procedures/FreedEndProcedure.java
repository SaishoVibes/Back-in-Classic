package net.mcreator.backinclassic.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.Entity;

import net.mcreator.backinclassic.BackInClassicModVariables;
import net.mcreator.backinclassic.BackInClassicMod;

import java.util.Map;

public class FreedEndProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure FreedEnd!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure FreedEnd!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (BackInClassicModVariables.MapVariables.get(world).HasFreedEnd) {
			if (((!((World.THE_END) == (entity.world.getDimensionKey()))) && (entity instanceof EndermanEntity))) {
				if (!entity.world.isRemote())
					entity.remove();
			}
		}
	}
}