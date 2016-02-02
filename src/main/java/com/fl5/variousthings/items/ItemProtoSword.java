package com.fl5.variousthings.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;

import com.fl5.variousthings.tabs.VaiousThingsTabs;

public class ItemProtoSword extends ItemSword
{
	public final ToolMaterial toolMaterial;
	
	
	
	public ItemProtoSword(ToolMaterial PROTOSWORD)
	{
		super(PROTOSWORD);
		toolMaterial = PROTOSWORD;
		setCreativeTab(VaiousThingsTabs.tabVariousThings);
		
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attackingEntity) {
		
		double d = attackingEntity.posX - entity.posX;
        double d1;
        for(d1 = attackingEntity.posZ - entity.posZ; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D)
        {
            d = (Math.random() - Math.random()) * 0.01D;
        }
		
	        entity.isAirBorne = true;
	        float f = MathHelper.sqrt_double(d * d + d1 * d1);
	        float f1 = 0.4F;
	        entity.motionX *= 5D;
	        entity.motionY *= 5D;
	        entity.motionZ *= 5D;
	        entity.motionX -= (d / (double)f) * (double)f1;
	        entity.motionY += 0.40000000596046448D;
	        entity.motionZ -= (d1 / (double)f) * (double)f1;
	        if(entity.motionY > 0.40000000596046448D)
	        {
	        	entity.motionY = 0.40000000596046448D;
	        }
	    return true;
	}
	
	
}
