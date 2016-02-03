package com.fl5.variousthings.render.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.fl5.variousthings.tileentity.TileEntityItemDisplay;

public class ItemDisplayRenderer extends TileEntitySpecialRenderer {
	
	private EntityItem entityItem = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D);

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double posX, double posY, double posZ, float partialTick, int destroyStage)
	{
		TileEntityItemDisplay itemDisplay = (TileEntityItemDisplay) tileEntity;
		
		GL11.glPushMatrix();
		
		GlStateManager.translate(posX, posY, posZ);
		
		WorldRenderer renderer = Tessellator.getInstance().getWorldRenderer();
		renderer.setBrightness(15728880);
		
		
		
		renderer.startDrawingQuads();
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("minecraft:textures/blocks/furnace_top.png"));
		// -Z
        renderer.setNormal(0, 0, -1);
        renderer.addVertexWithUV(1.0, 0.0, 0.0, 0.0, 0.25);
        renderer.addVertexWithUV(0.0, 0.0, 0.0, 1.0, 0.25);
        renderer.addVertexWithUV(0.0, 0.25, 0.0, 1.0, 0.0);
        renderer.addVertexWithUV(1.0, 0.25, 0.0, 0.0, 0.0);
        // +Z
        renderer.setNormal(0, 0, 1);
        renderer.addVertexWithUV(0.0, 0.0, 1.0, 0.0, 0.25);
        renderer.addVertexWithUV(1.0, 0.0, 1.0, 1.0, 0.25);
        renderer.addVertexWithUV(1.0, 0.25, 1.0, 1.0, 0.0);
        renderer.addVertexWithUV(0.0, 0.25, 1.0, 0.0, 0.0);
        // -X
        renderer.setNormal(-1, 0, 0);
        renderer.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0.25);
        renderer.addVertexWithUV(0.0, 0.0, 1.0, 1.0, 0.25);
        renderer.addVertexWithUV(0.0, 0.25, 1.0, 1.0, 0.0);
        renderer.addVertexWithUV(0.0, 0.25, 0.0, 0.0, 0.0);
        // +X
        renderer.setNormal(1, 0, 0);
        renderer.addVertexWithUV(1.0, 0.0, 1.0, 0.0, 0.25);
        renderer.addVertexWithUV(1.0, 0.0, 0.0, 1.0, 0.25);
        renderer.addVertexWithUV(1.0, 0.25, 0.0, 1.0, 0.0);
        renderer.addVertexWithUV(1.0, 0.25, 1.0, 0.0, 0.0);
        // -Y
        renderer.setNormal(0, -1, 0);
        renderer.addVertexWithUV(0.0, 0.0, 1.0, 0.0, 1.0);
        renderer.addVertexWithUV(0.0, 0.0, 0.0, 1.0, 1.0);
        renderer.addVertexWithUV(1.0, 0.0, 0.0, 1.0, 0.0);
        renderer.addVertexWithUV(1.0, 0.0, 1.0, 0.0, 0.0);
        // +Y
        renderer.setNormal(0, 1, 0);
        renderer.addVertexWithUV(1.0, 0.25, 1.0, 0.0, 1.0);
        renderer.addVertexWithUV(1.0, 0.25, 0.0, 1.0, 1.0);
        renderer.addVertexWithUV(0.0, 0.25, 0.0, 1.0, 0.0);
        renderer.addVertexWithUV(0.0, 0.25, 1.0, 0.0, 0.0);
        Tessellator.getInstance().draw();
		
        GL11.glPopMatrix();
        
		if (itemDisplay.getItemContained() != null)
		{
			entityItem.setEntityItemStack(itemDisplay.getItemContained());

			GL11.glPushMatrix();
			
	        this.entityItem.hoverStart = 0.0F;
	        GL11.glTranslatef((float)posX + 0.5F, (float) posY + 0.25F, (float) posZ + 0.5F);
	        GlStateManager.rotate((tileEntity.getWorld().getTotalWorldTime() + partialTick) * 3, 0, 1, 0);
	        
	        GlStateManager.translate(0.0, 0, -0.075);

	        Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(entityItem, 0.0D, 0.0D, 0.075D, 0.0F, 0.0F);


			
			GL11.glPopMatrix();
		}
	}
}
