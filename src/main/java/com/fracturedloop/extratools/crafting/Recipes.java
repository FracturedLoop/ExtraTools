package com.fracturedloop.extratools.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.fracturedloop.extratools.init.ModBlocks;
import com.fracturedloop.extratools.init.ModItems;

public class Recipes {
	static ItemStack inkStack = new ItemStack(Items.dye,1,0);
	static ItemStack stick = new ItemStack(Items.stick);
	static ItemStack obsidian = new ItemStack(Blocks.obsidian);
	static ItemStack blazingDiamond = new ItemStack(ModItems.blazingDiamond);
	
	public static void init () {
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blazingDiamond), new Object[] {" A ", "ABA", " A ", 'A', Items.blaze_powder, 'B', Items.diamond});
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blazingAxe), new Object [] {"AA ", "AB ", " B ", 'A', blazingDiamond, 'B', stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blazingShovel), new Object [] {" A ", " B ", " B ", 'A', blazingDiamond, 'B', stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blazingPickaxe), new Object [] {"AAA", " B ", " B ", 'A', blazingDiamond, 'B', stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blazingSword), new Object [] {" A ", " A ", " B ", 'A', blazingDiamond, 'B', stick});
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.fallBoots), new Object [] {"OOO", "ODO", "OSO", 'O', obsidian, 'D', Items.diamond_boots, 'S', Items.slime_ball});
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.jumpBooster), new Object [] {"ACA", "BCB", "BBB", 'A', Items.slime_ball, 'B', Items.iron_ingot, 'C', Blocks.piston});
		
	}
	
}

