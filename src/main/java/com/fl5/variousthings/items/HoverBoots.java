package com.fl5.variousthings.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.fl5.variousthings.tabs.VaiousThingsTabs;

public class HoverBoots extends ItemArmor {

 public HoverBoots(ArmorMaterial material, int renderIndex, int armorType) {
	    super(material, renderIndex, armorType);
	    setCreativeTab(VaiousThingsTabs.tabVariousThings);
	   
	}
	
 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	 player.fallDistance = 0.0F;
 }
 
 
}
