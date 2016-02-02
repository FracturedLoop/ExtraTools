package com.fl5.variousthings.init;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.fl5.variousthings.helpers.RegisterHelper;
import com.fl5.variousthings.items.ItemBasic;
import com.fl5.variousthings.items.ItemBlazingAxe;
import com.fl5.variousthings.items.ItemBlazingDiamond;
import com.fl5.variousthings.items.ItemBlazingPickaxe;
import com.fl5.variousthings.items.ItemBlazingShovel;
import com.fl5.variousthings.items.ItemBlazingSword;
import com.fl5.variousthings.items.ItemFallBoots;
import com.fl5.variousthings.items.ItemNightGoggles;
import com.fl5.variousthings.items.ItemProtoSword;

public final class VariousThingsItems {

	public static Item runner_dude = new ItemBasic().setUnlocalizedName("runner_dude");
	public static Item laserBolt = new ItemBasic().setUnlocalizedName("laserBolt");

	//name, harvest level, durability, efficiency, damage, enchantability
	public static ToolMaterial BLAZINGDIAMOND = EnumHelper.addToolMaterial("BLAZINGDIAMOND", 3, 2000, 14.0F, 4.0F, 20);
	public static ToolMaterial PROTOSWORD = EnumHelper.addToolMaterial("PROTOSWORD", 3, 2000, 14.0F, 4.0F, 20);

	
	public static ArmorMaterial FALLBOOTS = EnumHelper.addArmorMaterial("FALLBOOTS", "variousthings:fall_boots", -1, new int[]{4, 8, 7, 4}, 15);
	public static ArmorMaterial HOVERBOOTS = EnumHelper.addArmorMaterial("HOVERBOOTS", "variousthings:hover_boots", -1, new int[]{4, 8, 7, 4}, 15);
	public static ArmorMaterial NIGHTGOGGLES = EnumHelper.addArmorMaterial("NIGHTGOGGLES", "variousthings:night_goggles", 2000, new int[]{4, 8, 7, 4}, 15);
	
	public static Item blazing_diamond = new ItemBlazingDiamond("blazing_diamond").setUnlocalizedName("blazing_diamond");
	
	public static Item blazing_sword = new ItemBlazingSword(BLAZINGDIAMOND).setUnlocalizedName("blazing_sword");
	public static Item blazing_shovel = new ItemBlazingShovel(BLAZINGDIAMOND).setUnlocalizedName("blazing_shovel");
	public static Item blazing_axe = new ItemBlazingAxe(BLAZINGDIAMOND).setUnlocalizedName("blazing_axe");
	public static Item blazing_pickaxe = new ItemBlazingPickaxe(BLAZINGDIAMOND).setUnlocalizedName("blazing_pickaxe");
	
	public static Item proto_sword = new ItemProtoSword(PROTOSWORD).setUnlocalizedName("proto_sword");
	
	
	public static Item fall_boots = new ItemFallBoots(FALLBOOTS, 1, 3).setUnlocalizedName("fall_boots");
	public static Item hover_boots = new ItemFallBoots(HOVERBOOTS, 1, 3).setUnlocalizedName("hover_boots");
	
	public static Item night_goggles = new ItemNightGoggles(NIGHTGOGGLES, 0, 0).setUnlocalizedName("night_goggles");


	
    public static void registerItems() {
    	RegisterHelper.registerItem(runner_dude);
    	RegisterHelper.registerItem(blazing_diamond);
    	RegisterHelper.registerItem(blazing_sword);
    	RegisterHelper.registerItem(blazing_shovel);
    	RegisterHelper.registerItem(blazing_axe);
    	RegisterHelper.registerItem(blazing_pickaxe);
    	RegisterHelper.registerItem(proto_sword);
    	RegisterHelper.registerItem(fall_boots);
    	RegisterHelper.registerItem(hover_boots);
    	RegisterHelper.registerItem(night_goggles);
    }
    
    public static void registerItemRenderer()
    {
    	RegisterHelper.registerItemRenderer(runner_dude);
    	RegisterHelper.registerItemRenderer(blazing_diamond);
    	RegisterHelper.registerItemRenderer(blazing_sword);
    	RegisterHelper.registerItemRenderer(blazing_shovel);
    	RegisterHelper.registerItemRenderer(blazing_axe);
    	RegisterHelper.registerItemRenderer(blazing_pickaxe);
    	RegisterHelper.registerItemRenderer(proto_sword);
    	RegisterHelper.registerItemRenderer(fall_boots);
    	RegisterHelper.registerItemRenderer(hover_boots);
    	RegisterHelper.registerItemRenderer(night_goggles);

    }
}
