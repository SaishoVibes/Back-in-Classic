package net.backinclassic.registry;

import net.backinclassic.BackInClassicMod;
import net.backinclassic.entity.Human;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.frozenblock.wilderwild.entity.AncientHornProjectile;
import net.frozenblock.wilderwild.entity.Firefly;
import net.frozenblock.wilderwild.entity.Jellyfish;
import net.frozenblock.wilderwild.entity.render.easter.EasterEggs;
import net.frozenblock.wilderwild.misc.WilderEnumValues;
import net.frozenblock.wilderwild.misc.WilderSharedConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.levelgen.Heightmap;

public final class RegisterEntities {

    public static final EntityType<Human> HUMAN = register(
            "human",
            FabricEntityTypeBuilder.createMob()
                    .spawnGroup(MobCategory.MISC)
                    .entityFactory(Human::new)
                    .defaultAttributes(Human::addAttributes)
                    .spawnRestriction(SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Human::canSpawn)
                    .dimensions(EntityDimensions.scalable(0.6F, 1.8F))
                    .build()
    );

    public static EntityType entity = (EntityType.Builder.<Human.CustomEntity>create(Human.CustomEntity::new, EntityClassification.MONSTER)
            .setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Human.CustomEntity::new)
            .size(0.6f, 1.8f)).build("human").setRegistryName("human");

    public static void init() {

    }

    private static <E extends Entity, T extends EntityType<E>> T register(String path, T entityType) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, BackInClassicMod.id(path), entityType);
    }
}
