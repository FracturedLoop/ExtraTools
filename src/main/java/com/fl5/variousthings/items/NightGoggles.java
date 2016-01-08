package com.fl5.variousthings.items;

import com.fl5.variousthings.init.VariousThingsItems;
import com.fl5.variousthings.tabs.VaiousThingsTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class NightGoggles extends ItemArmor{

	public NightGoggles(ArmorMaterial material, int renderIndex, int armorType) {
	    super(material, renderIndex, armorType);
	    setCreativeTab(VaiousThingsTabs.tabVariousThings);
	   
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(VariousThingsItems.nightGoggles) && !player.isPotionActive(Potion.nightVision))
		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20*30, 0));
	}
}
