package com.backinclassic;
//Thanks Charles445!
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import net.backinclassic.BackInClassicMod;

//@Mod("back_in_classic")
public class DamageTilt
{
	public DamageTilt()
	{
		//Packets
		PacketHandler.init();
		
		//Handlers
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
}
