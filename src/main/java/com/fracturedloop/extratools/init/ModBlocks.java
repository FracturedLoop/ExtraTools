package com.fracturedloop.extratools.init;

import net.minecraft.block.Block;

import com.fracturedloop.extratools.blocks.BasicBlock;
import com.fracturedloop.extratools.helpers.RegisterHelper;

public class ModBlocks {

	public static Block jumpBooster = new BasicBlock(1.0F, 3.0F, "pickaxe", 1, 0F).setUnlocalizedName("jumpBooster");
	public static Block levitatorBlock = new BasicBlock(1.0F, 3.0F, "pickaxe", 1, 0F).setUnlocalizedName("levitatorBlock");
	
	
	public static void registerBlocks() {
		RegisterHelper.registerBlock(jumpBooster);
		RegisterHelper.registerBlock(levitatorBlock);
	}

	public static void registerBlockRenderer() {
		RegisterHelper.registerBlockRenderer(jumpBooster);
		RegisterHelper.registerBlockRenderer(levitatorBlock);
	}
	

	
}
