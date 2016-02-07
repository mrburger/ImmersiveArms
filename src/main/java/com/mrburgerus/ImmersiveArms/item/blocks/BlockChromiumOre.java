package com.mrburgerus.ImmersiveArms.item.blocks;

import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockChromiumOre extends Block
{
    String unlocalizedName = "chromiumOre";

    protected BlockChromiumOre(String unlocalizedName, Material chromiumOre)
    {
        super(chromiumOre);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setHardness(7.0F);
        this.setResistance(1500.0F);
        this.setLightLevel(0.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setStepSound(soundTypeStone);
    }
}
