package com.fl5.variousthings.render.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.fl5.variousthings.tileentity.TileEntityItemDisplay;

public class ItemDisplayRenderer extends TileEntitySpecialRenderer {
	
	private EntityItem entityItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D);

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double posX, double posY, double posZ, float partialTick, int destroyStage)
	{
		TileEntityItemDisplay itemDisplay = (TileEntityItemDisplay) tileEntity;
		if (itemDisplay.getItemContained() != null)
		{
			entityItem.setEntityItemStack(itemDisplay.getItemContained());

			GL11.glPushMatrix();
			this.entityItem.hoverStart = 0F;

//			float xOffset = 0.0F;
//			float zOffset = 0.5F;
//			
//			switch (itemDisplay.getRotation())
//			{
//			case 0:
//				zOffset -= 0.15F;
//				break;
//			case 1:
//				xOffset += 0.35F;
//				zOffset += 0.2F;
//				break;
//			case 2:
//				zOffset += 0.55F;
//				break;
//			case 3:
//				xOffset -= 0.35F;
//				zOffset += 0.2F;
//				break;
//			}
			

			WorldRenderer renderer = Tessellator.getInstance().getWorldRenderer();
			renderer.setBrightness(15728880);
			GL11.glTranslatef((float) posX + 0.5F, (float) posY + 0.15F, (float) posZ + 0.5F);
			GlStateManager.rotate((tileEntity.getWorld().getTotalWorldTime() + partialTick) * 3, 0, 1, 0);
	        GlStateManager.translate(0.0, 0.0, -0.075);


			
			
			Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(entityItem, 0.0D, 0.0D, 0.075D, 0.0F, 0.0F);
			GlStateManager.translate(-0.1, 0, -0.1);

			
			GL11.glPopMatrix();
		}
	}
}
