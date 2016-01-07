package com.fl5.variousthings.proxies;

import com.fl5.variousthings.init.VariousThingsBlocks;
import com.fl5.variousthings.init.VariousThingsItems;

public class ClientProxy extends CommonProxy {

	public void registerRenderers()
	{
		VariousThingsItems.registerItemRenderer();
		VariousThingsBlocks.registerBlockRenderer();
	}
}
