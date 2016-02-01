package com.mrburgerus.ImmersiveArms.item;

import com.mrburgerus.ImmersiveArms.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockChromiumOre extends Block
{
    String unlocalizedName = "chromiumOre";

    protected BlockChromiumOre(String unlocalizedName, Material chromiumOre)
    {
        super(chromiumOre);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
        this.setCreativeTab(Main.immersiveTab);
        this.setHardness(7.0F);
        this.setResistance(1500.0F);
        this.setLightLevel(0.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeStone);
    }
}
