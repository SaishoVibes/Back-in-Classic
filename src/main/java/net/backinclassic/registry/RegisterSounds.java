package net.backinclassic.registry;

import net.backinclassic.BackInClassicMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public final class RegisterSounds {

    public static final SoundEvent HUMAN_OOF = register("entity.human.oof");
    public static final SoundEvent HUMAN_DEATH = register("entity.human.death");

	private static Holder.Reference<SoundEvent> registerForHolder(String string) {
		return registerForHolder(BackInClassicMod.id(string));
	}

	private static Holder.Reference<SoundEvent> registerForHolder(ResourceLocation resourceLocation) {
		return registerForHolder(resourceLocation, resourceLocation);
	}

    public static SoundEvent register(String path) {
		var id = BackInClassicMod.id(path);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

	private static Holder.Reference<SoundEvent> registerForHolder(ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, resourceLocation, SoundEvent.createVariableRangeEvent(resourceLocation2));
	}

    public static void init() {

    }

}
