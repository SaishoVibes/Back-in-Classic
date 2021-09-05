package net.backinclassic.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class ClassicNetherPortalTriggerUsedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure ClassicNetherPortalTriggerUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
				new ResourceLocation("back_in_classic:classic_nether"))))
				&& ((entity instanceof PlayerEntity) || (entity instanceof ServerPlayerEntity)))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent((("X: ") + "" + ((entity.getPosX())) + "" + ("Z: ") + "" + ((entity.getPosZ())))), (false));
			}
		}
	}
}
