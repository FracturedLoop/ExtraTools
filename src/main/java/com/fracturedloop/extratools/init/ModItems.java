package com.fracturedloop.extratools.init;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.fracturedloop.extratools.helpers.RegisterHelper;
import com.fracturedloop.extratools.items.BasicItem;
import com.fracturedloop.extratools.items.BlazingAxe;
import com.fracturedloop.extratools.items.BlazingDiamond;
import com.fracturedloop.extratools.items.BlazingPickaxe;
import com.fracturedloop.extratools.items.BlazingShovel;
import com.fracturedloop.extratools.items.BlazingSword;
import com.fracturedloop.extratools.items.FallBoots;

public final class ModItems {

	public static Item runnerDude = new BasicItem().setUnlocalizedName("runnerDude");
	
	public static ToolMaterial BLAZINGDIAMOND = EnumHelper.addToolMaterial("BLAZINGDIAMOND", 3, 2000, 14.0F, 4.0F, 20);
	public static ArmorMaterial FALLBOOTS = EnumHelper.addArmorMaterial("FALLBOOTS", "extratools:fallBoots", -1, new int[]{4, 8, 7, 4}, 15);
	public static ArmorMaterial HOVERBOOTS = EnumHelper.addArmorMaterial("HOVERBOOTS", "extratools:hoverBoots", -1, new int[]{4, 8, 7, 4}, 15);

	
	public static Item blazingDiamond = new BlazingDiamond("blazingDiamond").setUnlocalizedName("blazingDiamond");
	
	public static Item blazingSword = new BlazingSword(BLAZINGDIAMOND).setUnlocalizedName("blazingSword");
	public static Item blazingShovel = new BlazingShovel(BLAZINGDIAMOND).setUnlocalizedName("blazingShovel");
	public static Item blazingAxe = new BlazingAxe(BLAZINGDIAMOND).setUnlocalizedName("blazingAxe");
	public static Item blazingPickaxe = new BlazingPickaxe(BLAZINGDIAMOND).setUnlocalizedName("blazingPickaxe");
	
	public static Item fallBoots = new FallBoots(FALLBOOTS, 1, 3).setUnlocalizedName("fallBoots");
	public static Item hoverBoots = new FallBoots(HOVERBOOTS, 1, 3).setUnlocalizedName("hoverBoots");

	
    public static void registerItems() {
    	RegisterHelper.registerItem(runnerDude);
    	RegisterHelper.registerItem(blazingDiamond);
    	RegisterHelper.registerItem(blazingSword);
    	RegisterHelper.registerItem(blazingShovel);
    	RegisterHelper.registerItem(blazingAxe);
    	RegisterHelper.registerItem(blazingPickaxe);
    	RegisterHelper.registerItem(fallBoots);
    	RegisterHelper.registerItem(hoverBoots);
    }
    
    public static void registerItemRenderer()
    {
    	RegisterHelper.registerItemRenderer(runnerDude);
    	RegisterHelper.registerItemRenderer(blazingDiamond);
    	RegisterHelper.registerItemRenderer(blazingSword);
    	RegisterHelper.registerItemRenderer(blazingShovel);
    	RegisterHelper.registerItemRenderer(blazingAxe);
    	RegisterHelper.registerItemRenderer(blazingPickaxe);
    	RegisterHelper.registerItemRenderer(fallBoots);
    	RegisterHelper.registerItemRenderer(hoverBoots);
    }
}
