package com.fl5.variousthings;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {
	
	public static KeyBinding hoverBoots;
	
	public static void init() {
        //set the keybinding
        hoverBoots = new KeyBinding("key.hoverBoots", Keyboard.KEY_H, "VariousThings");

        // Register the KeyBinding to the ClientRegistry
        ClientRegistry.registerKeyBinding(hoverBoots);
	}
}
