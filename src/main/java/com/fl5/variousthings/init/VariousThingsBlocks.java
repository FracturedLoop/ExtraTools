package com.fl5.variousthings.init;

import net.minecraft.block.Block;

import com.fl5.variousthings.blocks.BasicBlock;
import com.fl5.variousthings.blocks.EncasedTorch;
import com.fl5.variousthings.helpers.RegisterHelper;

public class VariousThingsBlocks {

	public static Block jumpBooster = new BasicBlock(1.0F, 3.0F, "pickaxe", 1, 0F).setUnlocalizedName("jumpBooster");
	public static Block levitatorBlock = new BasicBlock(1.0F, 3.0F, "pickaxe", 1, 0F).setUnlocalizedName("levitatorBlock");
	
	public static Block encasedTorch = new EncasedTorch(1.0F, 3.0F, "pickaxe", 0, 0.875F).setUnlocalizedName("encasedTorch");
	
	public static void registerBlocks() {
		RegisterHelper.registerBlock(jumpBooster);
		RegisterHelper.registerBlock(levitatorBlock);
		RegisterHelper.registerBlock(encasedTorch);
	}

	public static void registerBlockRenderer() {
		RegisterHelper.registerBlockRenderer(jumpBooster);
		RegisterHelper.registerBlockRenderer(levitatorBlock);
		RegisterHelper.registerBlockRenderer(encasedTorch);
	}
	
	
	

	
}
