package net.backinclassic.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.backinclassic.BackInClassicModElements;

import java.lang.reflect.Method;

@BackInClassicModElements.ModElement.Tag
public class InstantBowGameRule extends BackInClassicModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("instantBow", GameRules.Category.PLAYER,
			create(false));
	public InstantBowGameRule(BackInClassicModElements instance) {
		super(instance, 29);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
