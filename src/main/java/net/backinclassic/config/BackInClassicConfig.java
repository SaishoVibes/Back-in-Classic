package net.backinclassic.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Category;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.TransitiveObject;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.backinclassic.BackInClassicMod;
import net.backinclassic.config.config.BICConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

@Config(name = "back_in_classic")
public class BackInClassicConfig extends PartitioningSerializer.GlobalData {

	@Category("misc")
	@TransitiveObject
	public final BICConfig config = new BICConfig();

    public static BackInClassicConfig get() {
        if (!BackInClassicMod.areConfigsInit) {
            AutoConfig.register(BackInClassicConfig.class, PartitioningSerializer.wrap(GsonConfigSerializer::new));
            BackInClassicMod.areConfigsInit = true;
        }
        return AutoConfig.getConfigHolder(BackInClassicConfig.class).getConfig();
    }

    public static Component text(String key) {
        return Component.translatable("option." +"back_in_classic" + "." + key);
    }

    public static Component tooltip(String key) {
        return Component.translatable("tooltip." + "back_in_classic" + "." + key);
    }

    @Environment(EnvType.CLIENT)
    public static Screen buildScreen(Screen parent) {
        var configBuilder = ConfigBuilder.create().setParentScreen(parent).setTitle(text("component.title"));
        configBuilder.setSavingRunnable(() -> AutoConfig.getConfigHolder(BackInClassicConfig.class).save());
		var misc = configBuilder.getOrCreateCategory(text("config"));
        ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();
        BICConfig.setupEntries(misc, entryBuilder);
        return configBuilder.build();
    }
}
