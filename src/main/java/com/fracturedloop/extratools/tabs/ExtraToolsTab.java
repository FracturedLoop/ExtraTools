package com.fracturedloop.extratools.tabs;

import com.fracturedloop.extratools.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ExtraToolsTab extends CreativeTabs {
	String name;
	
	public ExtraToolsTab(int par1, String par2Str)
	{
		super(par1, par2Str);
		this.name = par2Str;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		if (this.name == "tabExtraTools") 
		{
			return ModItems.blazingSword;
		}
		return null;
	}

}
