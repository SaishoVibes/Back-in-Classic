package net.backinclassic.entity;

import com.google.common.collect.ImmutableMap;
import net.backinclassic.procedures.HumanNaturalEntityVillageConditionProcedure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class Human extends Monster {
	public Human(EntityType<? extends Human> type, Level world) {
		super(type, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1, 40));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.targetSelector.addGoal(5, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(6, new MoveBackToVillageGoal(this, 0.6, false) {
			@Override
			public boolean canUse() {
				double x = Human.this.getX();
				double y = Human.this.getY();
				double z = Human.this.getZ();
				Entity entity = Human.this;
				return super.canUse() && HumanNaturalEntityVillageConditionProcedure.executeProcedure(ImmutableMap.of("world", entity.level));
			}

			@Override
			public boolean canContinueToUse() {
				double x = Human.this.getX();
				double y = Human.this.getY();
				double z = Human.this.getZ();
				Entity entity = Human.this;
				return super.canContinueToUse()
						&& HumanNaturalEntityVillageConditionProcedure.executeProcedure(ImmutableMap.of("world", entity.level));
			}
		});
		this.goalSelector.addGoal(7, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(8, new OpenDoorGoal(this, false));
	}

	public static AttributeSupplier.Builder addAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.3F).
				add(Attributes.ATTACK_DAMAGE, 3F);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource damageSource) {
		return BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("back_in_classic:human_oof"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("back_in_classic:human_death"));
	}
}
