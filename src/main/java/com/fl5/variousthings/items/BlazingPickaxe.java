package com.fl5.variousthings.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.fl5.variousthings.tabs.VaiousThingsTabs;

public class BlazingPickaxe extends ItemPickaxe
{
	public final ToolMaterial toolMaterial;
	
	
	
	public BlazingPickaxe(ToolMaterial BLAZINGDIAMOND)
	{
		super(BLAZINGDIAMOND);
		toolMaterial = BLAZINGDIAMOND;
		setCreativeTab(VaiousThingsTabs.tabVariousThings);
		
		
		
	}
	
	public void onUpdate(ItemStack itemstack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if(itemstack.isItemEnchanted() == false) {
			itemstack.addEnchantment(Enchantment.fireAspect, 3);
		}
	}
	
	
}
