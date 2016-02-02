package com.fl5.variousthings.proxies;

import net.minecraftforge.fml.client.registry.ClientRegistry;

import com.fl5.variousthings.init.VariousThingsBlocks;
import com.fl5.variousthings.init.VariousThingsItems;
import com.fl5.variousthings.render.tileentity.ItemDisplayRenderer;
import com.fl5.variousthings.tileentity.TileEntityItemDisplay;

public class ClientProxy extends CommonProxy {

	public void registerRenderers()
	{
		VariousThingsItems.registerItemRenderer();
		VariousThingsBlocks.registerBlockRenderer();

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityItemDisplay.class, new ItemDisplayRenderer());

	}
}