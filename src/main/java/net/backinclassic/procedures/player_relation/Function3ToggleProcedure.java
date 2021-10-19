package net.backinclassic.procedures.player_relation;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.backinclassic.BackInClassicModVariables;
import net.backinclassic.BackInClassicMod;

import java.util.Map;
import java.util.HashMap;

public class Function3ToggleProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
			Entity entity = event.getTarget();
			PlayerEntity sourceentity = event.getPlayer();
			if (event.getHand() != sourceentity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure Function3Toggle!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Function3Toggle!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((((entity.getCapability(BackInClassicModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BackInClassicModVariables.PlayerVariables())).F3_UUID) == (true))) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
			if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
				((PlayerEntity) sourceentity).sendStatusMessage(
						new StringTextComponent(((((entity) + "" + (": "))) + "" + ((entity.getDisplayName().getString())))), (false));
			}
		}
	}
}
