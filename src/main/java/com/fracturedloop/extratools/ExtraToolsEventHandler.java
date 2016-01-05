package com.fracturedloop.extratools;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovementInput;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import com.fracturedloop.extratools.init.ModBlocks;
import com.fracturedloop.extratools.init.ModItems;

public class ExtraToolsEventHandler {
	
	public static boolean hasLevitated;
	public static boolean hoverBootsOn = true;
	public boolean hasJumped = false;
	public boolean hasSnuck = false;
	private boolean wasJumping = false;
	private boolean tempJump;
	
	@SubscribeEvent
    public void bounce(LivingJumpEvent event) {
    	if (!(event.entity instanceof EntityPlayer)) {
    		return;
    	}
    	BlockPos underPlayer = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - 1, (int) Math.floor(event.entity.posZ));
    	BlockPos twoUnderPlayer = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - 2, (int) Math.floor(event.entity.posZ));
    	BlockPos threeUnderPlayer = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - 3, (int) Math.floor(event.entity.posZ));
    	BlockPos currentSearch;
    	
    	int blocksUnder = 1;
    	
    	float jumpMultiplier = 1;
    	if (event.entity.worldObj.getBlockState(underPlayer).getBlock() == ModBlocks.jumpBooster) {
    		currentSearch = underPlayer;
    		blocksUnder = 1;
    		
    	}

    	else if (event.entity.worldObj.getBlockState(twoUnderPlayer).getBlock() == ModBlocks.jumpBooster) {
    		currentSearch = twoUnderPlayer;
    		blocksUnder = 2;

    	
    	}
    	else if (((EntityPlayer) event.entity).getCurrentArmor(0) != null && ((EntityPlayer) event.entity).getCurrentArmor(0).getItem() == ModItems.hoverBoots && hoverBootsOn == true) {
    	 			
    	 		currentSearch = threeUnderPlayer;
        		blocksUnder = 3;
        		
    	 }
    	
    	
    	else {
    		return;
    	}
    	
    	while(event.entity.worldObj.getBlockState(currentSearch).getBlock() == ModBlocks.jumpBooster) {
			jumpMultiplier += 0.5;
			blocksUnder += 1;
			currentSearch = new BlockPos((int) Math.floor(event.entity.posX), (int) Math.floor(event.entity.posY) - blocksUnder, (int) Math.floor(event.entity.posZ));
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
		
		
		if ((event.player.worldObj.getBlockState(twoUnderPlayer).getBlock() == ModBlocks.levitatorBlock || event.player.worldObj.getBlockState(underPlayer).getBlock() == ModBlocks.levitatorBlock || event.player.worldObj.getBlockState(threeUnderPlayer).getBlock() == ModBlocks.levitatorBlock || event.player.worldObj.getBlockState(fourUnderPlayer).getBlock() == ModBlocks.levitatorBlock)) {
			
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
				player.motionY = -0.2;				
			}
			else if (player.posY - 2 - levitatorBlock.getY() >= 2.8 && player.posY - 2 - levitatorBlock.getY() <= 3.0) {
				player.motionY = 0;
			}
			else if (player.posY - 2 - levitatorBlock.getY() < 2.8) {
				player.motionY = 0.2;
			}
			hasLevitated = true;
			return;
		}
	}
	
	@SubscribeEvent
	public void negateFallDamage(LivingFallEvent event) {
		if (hasLevitated == true) {
			event.setCanceled(true);
			hasLevitated = false;
		}
		return;
	}
	
	
	
	@SubscribeEvent
	public void hover(PlayerTickEvent event) {
		BlockPos underPlayer = new BlockPos((int) Math.floor(event.player.posX), (int) event.player.posY - 1, (int) Math.floor(event.player.posZ));
	 	BlockPos twoUnderPlayer = new BlockPos((int) Math.floor(event.player.posX), (int) event.player.posY - 2, (int) Math.floor(event.player.posZ));
	 	EntityPlayer player = event.player; 
	 	if (player.getCurrentArmor(0) != null) {
	 		if (player.getCurrentArmor(0).getItem() == ModItems.hoverBoots) {
	 				if (hoverBootsOn == true) {
	 					
	 					MovementInput input = Minecraft.getMinecraft().thePlayer.movementInput;
	 					
	 					tempJump = input.jump;
	 				    if (input.jump && !wasJumping && !hasJumped) {
	 						player.jump();
	 						hasJumped = true;
	 					}
	 					
	 					else if (input.sneak) {
	 						player.motionY = -0.2;
	 					}
	 					//float up and decrease speed to a graceful stop
	 					else if (!(player.worldObj.getBlockState(underPlayer).getBlock() == Blocks.air)) {
	 						player.motionY = (1 - (player.posY - Math.floor(player.posY))) / 5;
	 						if (player.motionY < 0.03) player.motionY = 0.03;
	 						hasJumped = false;
	 					} 
	 					
	 					//stop once desired height has been reached
	 					else if ((player.posY - underPlayer.getY() >= 1.0 && player.posY - underPlayer.getY() <= 1.1) && player.worldObj.getBlockState(twoUnderPlayer).getBlock() != Blocks.air && player.motionY <= 0.1) {
	 						player.motionY = 0;
	 					} 
			
	 				}
	 		}
	 	} 
	 	
	 	wasJumping = tempJump;
	 		
	} 
	 
	
	
	
}
