package com.backinclassic;
//Thanks Charles445!
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.network.NetworkDirection;

import net.backinclassic.BackInClassicMod;

public class EventHandler
{
	@SubscribeEvent
	public void onKnockback(LivingKnockBackEvent event)
	{
		if(event.getEntityLiving() instanceof PlayerEntity)
		{
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
			if(player.world.isRemote)
				return;
			
			//Server Side
			
			if(player instanceof ServerPlayerEntity)
			{
				ServerPlayerEntity serverPlayer = (ServerPlayerEntity)player;
				
				//Check if the connection is null, which may happen with fake players if they get knocked back
				if(serverPlayer.connection == null)
					return;
				
				//Check if the network manager is null too, while we're at it.
				if(serverPlayer.connection.getNetworkManager() == null)
					return;
				
				PacketHandler.instance.sendTo(new MessageUpdateAttackYaw(player), serverPlayer.connection.getNetworkManager(), NetworkDirection.PLAY_TO_CLIENT);
			}
		}
	}
}
