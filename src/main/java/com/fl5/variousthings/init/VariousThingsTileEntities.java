package com.fl5.variousthings.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.fl5.variousthings.tileentity.TileEntityItemDisplay;

public class VariousThingsTileEntities {
	public static void init() {
        GameRegistry.registerTileEntity(TileEntityItemDisplay.class, "item_display");
    }
}
