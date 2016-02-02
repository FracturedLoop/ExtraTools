package com.fl5.variousthings.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.fl5.variousthings.tabs.VaiousThingsTabs;

public class EnderSummoner extends Block
{
    public EnderSummoner()
    {
        super(Material.rock); // experiment with different material types
        this.setCreativeTab(VaiousThingsTabs.tabVariousThings);
        this.setStepSound(soundTypeStone);
        this.setHardness(50); // how long it takes to break
        this.setResistance(3000); // resistance to explosives
        this.setHarvestLevel("pickaxe", 3); // what can break/what material can break
        this.setLightLevel(0); // light emitted (e.g. glowstone)
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
    }
    
    @Override
    public boolean isOpaqueCube() {
    	return false;
    }
    
    @Override
    public boolean isFullCube() {
    	return false;
    }
    
    @Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
    	
        
            if (!world.isRemote)
            {
                BlockPos blockpos = world.getStrongholdPos("Stronghold", new BlockPos(player));

                if (blockpos != null)
                {
                    EntityEnderEye entityendereye = new EntityEnderEye(world, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5);
                    entityendereye.moveTowards(blockpos);
                    world.spawnEntityInWorld(entityendereye);
                    world.playAuxSFXAtEntity((EntityPlayer)null, 1002, new BlockPos(player), 0);

                   

                }
            }

            return true;
        }
}
