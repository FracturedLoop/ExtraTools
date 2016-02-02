package com.fl5.variousthings.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.fl5.variousthings.gui.inventory.ContainerItemDisplay;
import com.fl5.variousthings.tileentity.TileEntityItemDisplay;
import com.fl5.variousthings.gui.GuiItemDisplay;

public class GuiHandler implements IGuiHandler {

    
    public static final int MOD_TILE_ENTITY_GUI = 0;
    public static int getGuiID() {return MOD_TILE_ENTITY_GUI;}

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == MOD_TILE_ENTITY_GUI)
        	return new ContainerItemDisplay(player.inventory, (TileEntityItemDisplay) world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == MOD_TILE_ENTITY_GUI)
            return new GuiItemDisplay(player.inventory, (TileEntityItemDisplay) world.getTileEntity(new BlockPos(x, y, z)));

        return null;
    }
}
