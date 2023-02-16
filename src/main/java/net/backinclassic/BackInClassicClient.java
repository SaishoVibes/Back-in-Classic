package net.backinclassic;

import net.backinclassic.entity.model.HumanModel;
import net.backinclassic.entity.renderer.HumanRenderer;
import net.backinclassic.registry.RegisterEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class BackInClassicClient implements ClientModInitializer {

    public static final ModelLayerLocation HUMAN = new ModelLayerLocation(BackInClassicMod.id("human"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(RegisterEntities.HUMAN, HumanRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(HUMAN, HumanModel::createBodyLayer);
    }
}
