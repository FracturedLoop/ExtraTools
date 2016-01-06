package com.fracturedloop.extratools;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {
	
	public static KeyBinding hoverBoots;
	
	public static void init() {
        //set the keybinding
        hoverBoots = new KeyBinding("key.hoverBoots", Keyboard.KEY_H, "ExtraTools");

        // Register the KeyBinding to the ClientRegistry
        ClientRegistry.registerKeyBinding(hoverBoots);
	}
}
