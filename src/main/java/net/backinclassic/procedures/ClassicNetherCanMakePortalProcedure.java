package net.backinclassic.procedures;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.Entity;

import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class ClassicNetherCanMakePortalProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure ClassicNetherCanMakePortal!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		boolean returnLogic = false;
		if ((((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
				new ResourceLocation("back_in_classic:classic_overworld"))))
				|| ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("back_in_classic:classic_nether")))))) {
			returnLogic = (boolean) (true);
		} else {
			returnLogic = (boolean) (false);
		}
		return returnLogic;
	}
}
