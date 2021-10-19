package net.backinclassic.procedures.player_relation;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.backinclassic.BackInClassicModVariables;
import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class UUIDVIEWOnKeyReleasedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure UUIDVIEWOnKeyReleased!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(BackInClassicModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BackInClassicModVariables.PlayerVariables())).F3_UUID) != (true))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(BackInClassicModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.F3_UUID = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("UUID ON"), (false));
			}
		} else {
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(BackInClassicModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.F3_UUID = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("UUID OFF"), (false));
			}
		}
	}
}
