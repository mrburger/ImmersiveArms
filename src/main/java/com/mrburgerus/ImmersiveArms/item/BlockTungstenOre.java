package com.mrburgerus.ImmersiveArms.item;


import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTungstenOre extends Block
{
    String unlocalizedName = "tungstenOre";

    protected BlockTungstenOre(String unlocalizedName, Material vanadiumOre)
    {
        super(vanadiumOre);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(ImmersiveArms.MODID + ":" + unlocalizedName);
        this.setCreativeTab(ImmersiveArms.immersiveTab);
        this.setHardness(5.0F);
        this.setResistance(1500.0F);
        this.setLightLevel(0.0F);
        this.setHarvestLevel("pickaxe", 2);
        this.setStepSound(soundTypeStone);
    }


}
