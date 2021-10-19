package net.backinclassic.procedures.player_relation;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.backinclassic.BackInClassicMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class TNTExtinguishProcedure {
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
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure TNTExtinguish!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency sourceentity for procedure TNTExtinguish!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure TNTExtinguish!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure TNTExtinguish!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure TNTExtinguish!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure TNTExtinguish!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == Items.SHEARS)) {
			if ((entity instanceof TNTEntity)) {
				{
					ItemStack _ist = ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(x, (-40), z);
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (-40), z, _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.TNT));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if (((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == Blocks.AIR.asItem())
				&& (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == Items.SHEARS))) {
			if ((entity instanceof TNTEntity)) {
				{
					ItemStack _ist = ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemOffhand() : ItemStack.EMPTY);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(x, (-40), z);
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (-40), z, _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.TNT));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
