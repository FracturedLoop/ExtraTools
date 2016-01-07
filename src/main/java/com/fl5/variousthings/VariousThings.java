package com.fl5.variousthings;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.fl5.variousthings.crafting.Recipes;
import com.fl5.variousthings.events.KeyInputHandler;
import com.fl5.variousthings.events.VariousThingsEventHandler;
import com.fl5.variousthings.help.Reference;
import com.fl5.variousthings.init.VariousThingsBlocks;
import com.fl5.variousthings.init.VariousThingsItems;
import com.fl5.variousthings.proxies.CommonProxy;

@Mod(modid = VariousThings.MODID, name = VariousThings.MODNAME, version = VariousThings.VERSION)

public class VariousThings {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;

    public static final String MODID = "variousthings";
    public static final String MODNAME = "VariousThings";
    public static final String VERSION = "1.0.0";

    @Instance
    public static VariousThings instance = new VariousThings();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	FMLCommonHandler.instance().bus().register(new KeyInputHandler());
    	KeyBindings.init();
    	VariousThingsItems.registerItems();
    	VariousThingsBlocks.registerBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	
    	
    	proxy.registerRenderers();
    	Recipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	MinecraftForge.EVENT_BUS.register(new VariousThingsEventHandler());
    	FMLCommonHandler.instance().bus().register(new VariousThings());
    	FMLCommonHandler.instance().bus().register(new VariousThingsEventHandler());
    }
    
    
    
    
}