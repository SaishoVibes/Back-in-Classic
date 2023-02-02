package net.backinclassic.registry;

import net.backinclassic.BackInClassicMod;
import net.backinclassic.entity.Human;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public final class RegisterEntities {

    public static final EntityType<Human> HUMAN = register(
            "human",
            FabricEntityTypeBuilder.createMob()
                    .spawnGroup(MobCategory.MISC)
                    .entityFactory(Human::new)
                    .defaultAttributes(Human::addAttributes)
                    .dimensions(EntityDimensions.scalable(0.6F, 1.8F))
                    .build()
    );

    public static void init() {

    }

    private static <E extends Entity, T extends EntityType<E>> T register(String path, T entityType) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, BackInClassicMod.id(path), entityType);
    }
}
