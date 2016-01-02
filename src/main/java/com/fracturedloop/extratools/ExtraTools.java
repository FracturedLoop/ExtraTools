package com.fracturedloop.extratools;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.fracturedloop.extratools.crafting.Recipes;
import com.fracturedloop.extratools.help.Reference;
import com.fracturedloop.extratools.init.ModBlocks;
import com.fracturedloop.extratools.init.ModItems;
import com.fracturedloop.extratools.proxies.CommonProxy;

@Mod(modid = ExtraTools.MODID, name = ExtraTools.MODNAME, version = ExtraTools.VERSION)

public class ExtraTools {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;

    public static final String MODID = "extratools";
    public static final String MODNAME = "ExtraTools";
    public static final String VERSION = "1.0.0";

    @Instance
    public static ExtraTools instance = new ExtraTools();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	ModItems.registerItems();
    	ModBlocks.registerBlocks();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	
    	
    	proxy.registerRenderers();
    	Recipes.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	MinecraftForge.EVENT_BUS.register(new ExtraToolsEventHandler());
    	FMLCommonHandler.instance().bus().register(new ExtraTools());
    	FMLCommonHandler.instance().bus().register(new ExtraToolsEventHandler());
    }
    
    
    
    
}