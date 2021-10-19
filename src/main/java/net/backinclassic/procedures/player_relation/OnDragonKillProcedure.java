package net.backinclassic.procedures.player_relation;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.backinclassic.BackInClassicModVariables;
import net.backinclassic.BackInClassicMod;

import java.util.Map;

public class OnDragonKillProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure OnDragonKill!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure OnDragonKill!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("minecraft:end/kill_dragon")))
						.isDone()
				: false)) {
			BackInClassicModVariables.MapVariables.get(world).HasFreedEnd = (boolean) (true);
			BackInClassicModVariables.MapVariables.get(world).syncData(world);
		} else {
			BackInClassicModVariables.MapVariables.get(world).HasFreedEnd = (boolean) (false);
			BackInClassicModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
