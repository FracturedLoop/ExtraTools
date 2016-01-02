package com.fracturedloop.extratools.items;

import com.fracturedloop.extratools.tabs.ModTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FallBoots extends ItemArmor{

 public FallBoots(ArmorMaterial material, int renderIndex, int armorType) {
	    super(material, renderIndex, armorType);
	    setCreativeTab(ModTabs.tabExtraTools);
	   
	}
	
 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
	 player.fallDistance = 0.0F;
 }
}
