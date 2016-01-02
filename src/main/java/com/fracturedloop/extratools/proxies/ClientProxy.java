package com.fracturedloop.extratools.proxies;

import com.fracturedloop.extratools.init.ModBlocks;
import com.fracturedloop.extratools.init.ModItems;

//import com.fracturedloop.extratools.client.render.items.ItemRenderRegister;

public class ClientProxy extends CommonProxy {

	public void registerRenderers()
	{
		ModItems.registerItemRenderer();
		ModBlocks.registerBlockRenderer();
	}
}
