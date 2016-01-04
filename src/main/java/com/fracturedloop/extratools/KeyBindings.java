package com.fracturedloop.extratools;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {
	
	public static KeyBinding hoverBoots;
	
	public static void init() {
        // Define the "jump" binding, with (unlocalized) name "key.ping" and
        // the category with (unlocalized) name "key.categories.mymod" and
        // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)
        hoverBoots = new KeyBinding("key.hoverBoots", Keyboard.KEY_H, "key.categories.ExtraTools");

        // Register both KeyBindings to the ClientRegistry
        ClientRegistry.registerKeyBinding(hoverBoots);
	}
}
