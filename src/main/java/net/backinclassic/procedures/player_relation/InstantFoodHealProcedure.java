package net.backinclassic.procedures.player_relation;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.backinclassic.world.DoBetaHungerGameRule;
import net.backinclassic.BackInClassicMod;

import java.util.Map;
import java.util.HashMap;

public class InstantFoodHealProcedure {
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
				BackInClassicMod.LOGGER.warn("Failed to load dependency entity for procedure InstantFoodHeal!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BackInClassicMod.LOGGER.warn("Failed to load dependency world for procedure InstantFoodHeal!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((ItemTags.getCollection().getTagByID(new ResourceLocation(("back_in_classic:foodstuffs").toLowerCase(java.util.Locale.ENGLISH)))
				.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()))
				&& ((world.getWorldInfo().getGameRulesInstance().getBoolean(DoBetaHungerGameRule.gamerule)) == (true)))) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 5));
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setCount(
					(int) (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).getCount()) - 1));
		}
	}
}
