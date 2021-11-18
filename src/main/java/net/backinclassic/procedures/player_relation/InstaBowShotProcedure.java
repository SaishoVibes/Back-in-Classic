package net.backinclassic.procedures.player_relation;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.backinclassic.world.InstantBowGameRule;
import net.backinclassic.enchantment.SharpshotEnchantment;
import net.backinclassic.BackInClassicMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class InstaBowShotProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onUseItemStart(LivingEntityUseItemEvent.Start event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double duration = event.getDuration();
				ItemStack itemstack = event.getItem();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("itemstack", itemstack);
				dependencies.put("duration", duration);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure InstaBowShot!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency itemstack for procedure InstaBowShot!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency x for procedure InstaBowShot!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency y for procedure InstaBowShot!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency z for procedure InstaBowShot!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure InstaBowShot!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double oldDamage = 0;
		if (((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.ARROW)) : false)
				|| (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayerEntity) {
							return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
						} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
							NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
							return _npi != null && _npi.getGameType() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity)))
				&& ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == Items.BOW)
						&& ((world.getWorldInfo().getGameRulesInstance().getBoolean(InstantBowGameRule.gamerule)) == (true))))) {
			oldDamage = (double) ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getDamage());
			if (entity instanceof LivingEntity) {
				Entity _ent = entity;
				if (!_ent.world.isRemote()) {
					ArrowEntity entityToSpawn = new ArrowEntity(_ent.world, (LivingEntity) entity);
					entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z,
							(float) (2 + ((EnchantmentHelper.getEnchantmentLevel(SharpshotEnchantment.enchantment, (itemstack))) / 2)), 0);
					entityToSpawn.setDamage((float) (5 + ((EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, (itemstack))) / 2)));
					entityToSpawn.setKnockbackStrength(
							(int) (Math.random() + ((EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, (itemstack))) / 2)));
					_ent.world.addEntity(entityToSpawn);
				}
			}
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
			if ((!(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayerEntity) {
						return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
					} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
						NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
								.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
						return _npi != null && _npi.getGameType() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity)))) {
				if ((!((EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)))) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(Items.ARROW);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
			}
			if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"data merge entity @e[type=arrow,distance=..2,limit=1] {Fire:32767}");
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem(), (int) 2);
			if ((Math.random() >= 0.2)) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"playsound back_in_classic:instant_bow_shot player @p ~ ~ ~ .75 1");
				} else {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"playsound back_in_classic:instant_bow_shot player @a ~ ~ ~ .75 1");
				}
			} else if ((Math.random() >= 0.1)) {
				if (world instanceof World && !world.isRemote()) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"playsound back_in_classic:instant_bow_shot player @p ~ ~ ~ .75 1.25");
				} else {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"playsound back_in_classic:instant_bow_shot player @a ~ ~ ~ .75 1.25");
				}
			} else {
				if (world instanceof World && !world.isRemote()) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"playsound back_in_classic:instant_bow_shot player @p ~ ~ ~ .75 .75");
				} else {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							"playsound back_in_classic:instant_bow_shot player @a ~ ~ ~ .75 .75");
				}
			}
		}
	}
}
