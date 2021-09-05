package com.backinclassic;
//Thanks Charles445!
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import net.backinclassic.BackInClassicMod;

public class PacketHandler
{
	
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel instance = NetworkRegistry.newSimpleChannel(
			new ResourceLocation("back_in_classic", "main"),
			() -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals
	);
	
	
	public static void init()
	{
		instance.registerMessage(0, MessageUpdateAttackYaw.class, MessageUpdateAttackYaw::encode, MessageUpdateAttackYaw::decode, MessageUpdateAttackYaw::handle);
	}
}
