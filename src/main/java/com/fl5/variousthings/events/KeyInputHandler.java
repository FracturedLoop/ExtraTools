package com.fl5.variousthings.events;

import com.fl5.variousthings.KeyBindings;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
	
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBindings.hoverBoots.isPressed()) {
        	if (VariousThingsEventHandler.hoverBootsOn == true) {
        		VariousThingsEventHandler.hoverBootsOn = false;
            }
            else {
            	VariousThingsEventHandler.hoverBootsOn = true;
            }
        	System.out.println("HoverBoots on = " + VariousThingsEventHandler.hoverBootsOn);
        }
    }
}
