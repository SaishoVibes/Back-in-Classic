package net.backinclassic;

import net.backinclassic.registry.RegisterEntities;
import net.backinclassic.registry.RegisterSounds;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BackInClassicMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger(BackInClassicMod.class);
    public static final String MODID = "back_in_classic";
	public static final String NAME = "Back in Classic";
	public static boolean areConfigsInit;

	@Override
	public void onInitialize() {
		RegisterSounds.init();
		RegisterEntities.init();

	}

	public static ResourceLocation id (String path) {
		return new ResourceLocation(MODID, path);
	}

}
