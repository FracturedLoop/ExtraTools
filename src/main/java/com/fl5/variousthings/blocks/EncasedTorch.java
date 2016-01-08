package com.fl5.variousthings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.fl5.variousthings.tabs.VaiousThingsTabs;

public class EncasedTorch extends Block {
    public EncasedTorch(float hardness, float resistance, String harvestType, int harvestLevel, float lightLevel) {
        super(Material.glass); // experiment with different material types
        this.setCreativeTab(VaiousThingsTabs.tabVariousThings);
        this.setStepSound(soundTypeGlass);
        this.setHardness(hardness); // how long it takes to break
        this.setResistance(resistance); // resistance to explosives
        this.setHarvestLevel(harvestType, harvestLevel); // what can break/what material can break
        this.setLightLevel(lightLevel); // light emitted (e.g. glowstone)
    }
    
    @Override
    public boolean isOpaqueCube() {
		return false;
    }
}
