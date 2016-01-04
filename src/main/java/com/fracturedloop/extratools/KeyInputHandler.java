package com.fracturedloop.extratools;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
	
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBindings.hoverBoots.isPressed()) {
        	if (ExtraToolsEventHandler.hoverBootsOn == true) {
        		ExtraToolsEventHandler.hoverBootsOn = false;
            }
            else {
            	ExtraToolsEventHandler.hoverBootsOn = true;
            }
        	System.out.println("HoverBoots on = " + ExtraToolsEventHandler.hoverBootsOn);
        }
    }
}
