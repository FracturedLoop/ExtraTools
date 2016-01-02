package com.fracturedloop.extratools.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.fracturedloop.extratools.tabs.ModTabs;

public class BlazingSword extends ItemSword
{
	public final ToolMaterial toolMaterial;
	
	
	
	public BlazingSword(ToolMaterial BLAZINGDIAMOND)
	{
		super(BLAZINGDIAMOND);
		toolMaterial = BLAZINGDIAMOND;
		setCreativeTab(ModTabs.tabExtraTools);
		
	}
	
	public void onUpdate(ItemStack itemstack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if(itemstack.isItemEnchanted() == false) {
			itemstack.addEnchantment(Enchantment.fireAspect, 3);
		}
	}
	
	
}
