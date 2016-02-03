package com.fl5.variousthings.item;

import com.fl5.variousthings.init.VariousThingsItems;
import com.fl5.variousthings.tabs.VaiousThingsTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemNightGoggles extends ItemArmor{

	public ItemNightGoggles(ArmorMaterial material, int renderIndex, int armorType) {
	    super(material, renderIndex, armorType);
	    setCreativeTab(VaiousThingsTabs.tabVariousThings);
	   
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(VariousThingsItems.night_goggles) && !player.isPotionActive(Potion.nightVision))
		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20*30, 0));
	}
}
