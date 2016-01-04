package com.fracturedloop.extratools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import com.fracturedloop.extratools.init.ModBlocks;
import com.fracturedloop.extratools.init.ModItems;

public class ExtraToolsEventHandler {
	
	public static boolean hasLevitated;
	public static boolean hoverBootsOn;
	
	@SubscribeEvent
    public void bounce(LivingJumpEvent event) {
    	if (!(event.entity instanceof EntityPlayer)) {
    		return;
    	}
    	BlockPos underPlayer = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - 1, (int) Math.floor(event.entity.posZ));
    	BlockPos twoUnderPlayer = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - 2, (int) Math.floor(event.entity.posZ));
    	BlockPos currentSearch;
    	
    	int blocksUnder = 1;
    	
    	float jumpMultiplier = 1;
    	if (event.entity.worldObj.getBlockState(underPlayer).getBlock() == ModBlocks.jumpBooster) {
    		currentSearch = underPlayer;
    		blocksUnder = 1;
    		
    		while(event.entity.worldObj.getBlockState(currentSearch).getBlock() == ModBlocks.jumpBooster) {
    			jumpMultiplier += 0.5;
    			blocksUnder += 1;
    			currentSearch = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - blocksUnder, (int) Math.floor(event.entity.posZ));
    			
    		}
    	}

    	else if (event.entity.worldObj.getBlockState(twoUnderPlayer).getBlock() == ModBlocks.jumpBooster) {
    		currentSearch = twoUnderPlayer;
    		blocksUnder = 2;
    		
    		while(event.entity.worldObj.getBlockState(currentSearch).getBlock() == ModBlocks.jumpBooster) {
    			jumpMultiplier += 0.5;
    			blocksUnder += 1;
    			currentSearch = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - blocksUnder, (int) Math.floor(event.entity.posZ));
    			
    		}
    	}
    	
    	else {
    		return;
    	}
    	
    	event.entity.motionY *= jumpMultiplier;
    	
    }
	
	
	@SubscribeEvent
	public void levitate(PlayerTickEvent event) {
		
		
		
		BlockPos underPlayer = new BlockPos((int) Math.floor(event.player.posX), (int) Math.floor(event.player.posY) - 1, (int) Math.floor(event.player.posZ));
		BlockPos twoUnderPlayer = new BlockPos((int) Math.floor(event.player.posX), (int) Math.floor(event.player.posY) - 2, (int) Math.floor(event.player.posZ));
		BlockPos threeUnderPlayer = new BlockPos((int) Math.floor(event.player.posX), (int) Math.floor(event.player.posY) - 3, (int) Math.floor(event.player.posZ));
		BlockPos fourUnderPlayer = new BlockPos((int) Math.floor(event.player.posX), (int) Math.floor(event.player.posY) - 4, (int) Math.floor(event.player.posZ));
		EntityPlayer player = event.player;
		BlockPos levitatorBlock = null;
		
		
		if (player.isAirBorne && (event.player.worldObj.getBlockState(twoUnderPlayer).getBlock() == ModBlocks.levitatorBlock || event.player.worldObj.getBlockState(underPlayer).getBlock() == ModBlocks.levitatorBlock || event.player.worldObj.getBlockState(threeUnderPlayer).getBlock() == ModBlocks.levitatorBlock || event.player.worldObj.getBlockState(fourUnderPlayer).getBlock() == ModBlocks.levitatorBlock)) {
			
			if (event.player.worldObj.getBlockState(underPlayer).getBlock() == ModBlocks.levitatorBlock) {
				levitatorBlock = underPlayer;
			}
			else if (event.player.worldObj.getBlockState(twoUnderPlayer).getBlock() == ModBlocks.levitatorBlock){
				levitatorBlock = twoUnderPlayer;
			}
			else if (event.player.worldObj.getBlockState(threeUnderPlayer).getBlock() == ModBlocks.levitatorBlock){
				levitatorBlock = threeUnderPlayer;
			}
			else {
				levitatorBlock = fourUnderPlayer;
			}
			
			if (player.isSneaking()) {
				player.motionY = -0.1;				
			}
			else if (player.posY - 2 - levitatorBlock.getY() >= 2.8 && player.posY - 2 - levitatorBlock.getY() <= 3.0) {
				player.motionY = 0;
			}
			else if (player.posY - 2 - levitatorBlock.getY() < 2.8) {
				player.motionY = 0.1;
			}
			hasLevitated = true;

		}
	}
	
	@SubscribeEvent
	public void negateFallDamage(LivingFallEvent event) {
		if (hasLevitated == true) {
			event.setCanceled(true);
			hasLevitated = false;
		}
		
	}
	
	
	
	@SubscribeEvent
	public void hover(PlayerTickEvent event) {
		BlockPos underPlayer = new BlockPos((int) Math.floor(event.player.posX), (int) event.player.posY - 1, (int) Math.floor(event.player.posZ));
	 	BlockPos twoUnderPlayer = new BlockPos((int) Math.floor(event.player.posX), (int) event.player.posY - 2, (int) Math.floor(event.player.posZ));
	 	EntityPlayer player = event.player; 
	 	if (player.getCurrentArmor(0) != null) {
	 		if (player.getCurrentArmor(0).getItem() == ModItems.hoverBoots) {
	 				if (hoverBootsOn == true) {
//	 					if (player.isSneaking()) {
//	 						player.motionY = -0.1;
//	 					}
	 			
	 					if (!(player.worldObj.getBlockState(underPlayer).getBlock() == Blocks.air)) {
	 						player.motionY = (1 - (player.posY - Math.floor(player.posY))) / 5;
	 						if (player.motionY < 0.03) player.motionY = 0.03;
	 					} 
			 
	 					else if ((player.posY - underPlayer.getY() >= 1.0 && player.posY - underPlayer.getY() <= 1.1) && player.worldObj.getBlockState(twoUnderPlayer).getBlock() != Blocks.air && player.motionY <= 0.1) {
	 						player.motionY = 0;
	 					} 
			
	 				}
	 		}
	 	} 
	 	
			
			
	 		
	} 
	
	
	

	/*@SubscribeEvent
	public void increaseHoverSpeed(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		
		if (player.getCurrentArmor(0).getItem() == ModItems.hoverBoots) {
			
			if (event.player instanceof EntityPlayer) {
				System.out.println(player.capabilities.getWalkSpeed());
			  	if (player.capabilities.getFlySpeed() != 0.1F) {
			       player.capabilities.setFlySpeed(0.1F);
				}
			}
			
		}
	} */ 
	
	
	
}
