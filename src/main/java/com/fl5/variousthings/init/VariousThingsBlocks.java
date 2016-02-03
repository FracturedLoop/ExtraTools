package com.fl5.variousthings.init;

import net.minecraft.block.Block;

import com.fl5.variousthings.block.BasicBlock;
import com.fl5.variousthings.block.BlockItemDisplay;
import com.fl5.variousthings.block.BlockEncasedTorch;
import com.fl5.variousthings.block.BlockEnderSummoner;
import com.fl5.variousthings.helpers.RegisterHelper;

public class VariousThingsBlocks {

	public static Block jump_booster = new BasicBlock(1.0F, 3.0F, "pickaxe", 1, 0F).setUnlocalizedName("jump_booster");
	public static Block levitator = new BasicBlock(1.0F, 3.0F, "pickaxe", 1, 0F).setUnlocalizedName("levitator");
	
	public static Block encased_torch = new BlockEncasedTorch(1.0F, 3.0F, "pickaxe", 0, 0.875F).setUnlocalizedName("encased_torch");
	
	public static Block ender_summoner = new BlockEnderSummoner().setUnlocalizedName("ender_summoner");
	
	public static Block item_display = new BlockItemDisplay().setUnlocalizedName("item_display");
	public static void registerBlocks() {
		RegisterHelper.registerBlock(jump_booster);
		RegisterHelper.registerBlock(levitator);
		RegisterHelper.registerBlock(encased_torch);
		RegisterHelper.registerBlock(ender_summoner);
		RegisterHelper.registerBlock(item_display);
	}

	public static void registerBlockRenderer() {
		RegisterHelper.registerBlockRenderer(jump_booster);
		RegisterHelper.registerBlockRenderer(levitator);
		RegisterHelper.registerBlockRenderer(encased_torch);
		RegisterHelper.registerBlockRenderer(ender_summoner);
		RegisterHelper.registerBlockRenderer(item_display);

	}
	
	
	

	
}
