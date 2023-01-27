package net.backinclassic.config.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import net.backinclassic.config.BackInClassicConfig;
import net.minecraft.client.gui.screens.Screen;

public class BackInClassicConfigScreenBuilder {

    public static ConfigScreenFactory<Screen> buildScreen() {
        return BackInClassicConfig::buildScreen;
    }

}
