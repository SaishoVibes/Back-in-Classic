package net.backinclassic.entity.renderer;

import net.backinclassic.BackInClassicClient;
import net.backinclassic.BackInClassicMod;
import net.backinclassic.entity.Human;
import net.backinclassic.entity.model.HumanModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class HumanRenderer extends HumanoidMobRenderer<Human, HumanModel<Human>> {
	private static final String TEXTURE = "textures/entity/human.png";

	public HumanRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanModel<>(context.bakeLayer(BackInClassicClient.HUMAN)), 0.6F);
	}

	@Override
	public ResourceLocation getTextureLocation(Human entity) {
		return BackInClassicMod.id(TEXTURE);
	}

}
