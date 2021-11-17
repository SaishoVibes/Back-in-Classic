package net.backinclassic.procedures.player_relation;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.backinclassic.BackInClassicModVariables;
import net.backinclassic.BackInClassicModElements;
import net.backinclassic.BackInClassicMod;

import java.util.Map;
import java.util.HashMap;

@BackInClassicModElements.ModElement.Tag
public class EndermanStopTargetProcedure extends BackInClassicModElements.ModElement {
	public EndermanStopTargetProcedure(BackInClassicModElements instance) {
		super(instance, 38);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure EndermanStopTarget!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure EndermanStopTarget!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure EndermanStopTarget!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure EndermanStopTarget!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure EndermanStopTarget!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((BackInClassicModVariables.MapVariables.get(world).HasFreedEnd)) {
			if ((((((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof PlayerEntity)
					|| (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof ServerPlayerEntity))
					&& (((World.THE_END) == (entity.world.getDimensionKey())) && (entity instanceof EndermanEntity)))) {
				((MobEntity) entity).setAttackTarget((MobEntity) entity);
			}
		}
	}

	@SubscribeEvent
	public void onEntitySetsAttackTarget(LivingSetAttackTargetEvent event) {
		LivingEntity entity = event.getTarget();
		LivingEntity sourceentity = event.getEntityLiving();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", sourceentity.getPosX());
		dependencies.put("y", sourceentity.getPosY());
		dependencies.put("z", sourceentity.getPosZ());
		dependencies.put("world", sourceentity.getEntityWorld());
		dependencies.put("entity", entity);
		dependencies.put("sourceentity", sourceentity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
