package com.fl5.variousthings.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.fl5.variousthings.init.VariousThingsBlocks;
import com.fl5.variousthings.init.VariousThingsItems;

public class Recipes {
	static ItemStack inkStack = new ItemStack(Items.dye,1,0);
	static ItemStack stick = new ItemStack(Items.stick);
	static ItemStack obsidian = new ItemStack(Blocks.obsidian);
	static ItemStack blazingDiamond = new ItemStack(VariousThingsItems.blazing_diamond);
	
	public static void init () {
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsItems.blazing_diamond), new Object[] {" A ", "ABA", " A ", 'A', Items.blaze_powder, 'B', Items.diamond});
		
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsItems.blazing_axe), new Object [] {"AA ", "AB ", " B ", 'A', blazingDiamond, 'B', stick});
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsItems.blazing_shovel), new Object [] {" A ", " B ", " B ", 'A', blazingDiamond, 'B', stick});
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsItems.blazing_pickaxe), new Object [] {"AAA", " B ", " B ", 'A', blazingDiamond, 'B', stick});
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsItems.blazing_sword), new Object [] {" A ", " A ", " B ", 'A', blazingDiamond, 'B', stick});
		
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsItems.fall_boots), new Object [] {"OOO", "ODO", "OSO", 'O', obsidian, 'D', Items.diamond_boots, 'S', Items.slime_ball});
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsItems.hover_boots), new Object [] {"OFO", "OLO", "BJB", 'O', obsidian, 'F', VariousThingsItems.fall_boots, 'L', VariousThingsBlocks.levitator, 'B', Items.blaze_powder, 'J', VariousThingsBlocks.jump_booster});
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsItems.night_goggles), new Object [] {" P ", "EDE", " O ", 'O', obsidian, 'P', new ItemStack(Items.potionitem, 1, 8262), 'E', Items.ender_eye, 'D', Items.diamond_helmet});
		
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsBlocks.jump_booster), new Object [] {"ACA", "BCB", "BBB", 'A', Items.slime_ball, 'B', Items.iron_ingot, 'C', Blocks.piston});
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsBlocks.levitator), new Object [] {"BFB", "OGO", "OOO", 'B', Blocks.iron_bars, 'F', Items.feather, 'O', obsidian, 'G', Items.ghast_tear});
		GameRegistry.addShapedRecipe(new ItemStack(VariousThingsBlocks.encased_torch), new Object [] {" P ", "PTP", " P ", 'P', Blocks.glass_pane, 'T', Blocks.torch});
	}
	
}

