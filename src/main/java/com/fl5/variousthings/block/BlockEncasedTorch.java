package com.fl5.variousthings.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

import com.fl5.variousthings.tabs.VaiousThingsTabs;

public class BlockEncasedTorch extends Block {
	
	 @Override
	    public boolean isOpaqueCube() {
			return false;
	    }
	    
	    @Override
	    public boolean isFullCube() {
	    	return false;
	    }
	    
	    @Override
	    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
	    	return false;
	    }
	    
	
    public BlockEncasedTorch(float hardness, float resistance, String harvestType, int harvestLevel, float lightLevel) {
        super(Material.glass); // experiment with different material types
        this.setCreativeTab(VaiousThingsTabs.tabVariousThings);
        this.setStepSound(soundTypeGlass);
        this.setHardness(hardness); // how long it takes to break
        this.setResistance(resistance); // resistance to explosives
        this.setHarvestLevel(harvestType, harvestLevel); // what can break/what material can break
        this.setLightLevel(lightLevel); // light emitted (e.g. glowstone)
        this.setLightOpacity(1);
    }
    
   
}
