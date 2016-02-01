package com.mrburgerus.ImmersiveArms.item;

import com.mrburgerus.ImmersiveArms.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockVanadiumOre extends Block
{
    String unlocalizedName = "vanadiumOre";

    protected BlockVanadiumOre(String unlocalizedName, Material vanadiumOre)
    {
        super(vanadiumOre);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Main.MODID + ":" + unlocalizedName);
        this.setCreativeTab(Main.immersiveTab);
        this.setHardness(5.0F);
        this.setResistance(1500.0F);
        this.setLightLevel(0.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeStone);
    }
}

