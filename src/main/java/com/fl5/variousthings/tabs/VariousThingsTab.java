package com.fl5.variousthings.tabs;

import com.fl5.variousthings.init.VariousThingsItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VariousThingsTab extends CreativeTabs {
	String name;
	
	public VariousThingsTab(int par1, String par2Str)
	{
		super(par1, par2Str);
		this.name = par2Str;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		if (this.name == "tabVariousThings") 
		{
			return VariousThingsItems.blazing_sword;
		}
		return null;
	}

}
