package net.backinclassic.config.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.backinclassic.config.BackInClassicConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import static net.backinclassic.config.BackInClassicConfig.text;
import static net.backinclassic.config.BackInClassicConfig.tooltip;

@me.shedaniel.autoconfig.annotation.Config(name = "config")
public final class BICConfig implements ConfigData {

	public boolean oldCombat = false;
	public boolean infiniteFluids = false;
	public boolean oldHunger = false;
	public boolean instantBow = true;
	public boolean reachAroundBlock = true;
	public boolean afterDeathExplosion = true;
	public boolean generateBiomes = true;

	@Environment(EnvType.CLIENT)
	public static void setupEntries(ConfigCategory category, ConfigEntryBuilder entryBuilder) {
		var config = BackInClassicConfig.get().config;
		//category.setBackground(new ResourceLocation("backinclassic", "textures/config/misc.png"));

		var oldCombat = category.addEntry(entryBuilder.startBooleanToggle(text("old_combat"), config.oldCombat)
				.setDefaultValue(false)
				.setSaveConsumer(newValue -> config.oldCombat = newValue)
				.setTooltip(tooltip("old_combat"))
				.build()
		);

		var infiniteFluids = category.addEntry(entryBuilder.startBooleanToggle(text("infinite_fluids"), config.infiniteFluids)
				.setDefaultValue(false)
				.setSaveConsumer(newValue -> config.infiniteFluids = newValue)
				.setTooltip(tooltip("infinite_fluids"))
				.build()
		);

		var oldHunger = category.addEntry(entryBuilder.startBooleanToggle(text("old_hunger"), config.oldHunger)
				.setDefaultValue(false)
				.setSaveConsumer(newValue -> config.oldHunger = newValue)
				.setTooltip(tooltip("old_hunger"))
				.build()
		);

		var instantBow = category.addEntry(entryBuilder.startBooleanToggle(text("instant_bow"), config.instantBow)
				.setDefaultValue(true)
				.setSaveConsumer(newValue -> config.instantBow = newValue)
				.setTooltip(tooltip("instant_bow"))
				.build()
		);

		var reachAroundBlock = category.addEntry(entryBuilder.startBooleanToggle(text("reach_around_block"), config.reachAroundBlock)
				.setDefaultValue(true)
				.setSaveConsumer(newValue -> config.reachAroundBlock = newValue)
				.setTooltip(tooltip("reach_around_block"))
				.build()
		);

		var afterDeathExplosion = category.addEntry(entryBuilder.startBooleanToggle(text("after_death_explosion"), config.afterDeathExplosion)
				.setDefaultValue(false)
				.setSaveConsumer(newValue -> config.afterDeathExplosion = newValue)
				.setTooltip(tooltip("after_death_explosion"))
				.build()
		);

		var generateBiomes = category.addEntry(entryBuilder.startBooleanToggle(text("generate_biomes"), config.generateBiomes)
				.setDefaultValue(true)
				.setSaveConsumer(newValue -> config.generateBiomes = newValue)
				.setTooltip(tooltip("generate_biomes"))
				.build()
		);

	}
}
