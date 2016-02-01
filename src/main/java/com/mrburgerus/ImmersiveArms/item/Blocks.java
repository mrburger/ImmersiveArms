package com.mrburgerus.ImmersiveArms.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks
{
    public static Block vanadiumOre;
    public static Block chromiumOre;
    public static Block tungstenOre;

    public static final void init()
    {
        GameRegistry.registerBlock(vanadiumOre = new BlockVanadiumOre("vanadiumOre", Material.rock), "vanadiumOre");
        GameRegistry.registerBlock(chromiumOre = new BlockChromiumOre("chromiumOre", Material.rock), "chromiumOre");
        GameRegistry.registerBlock(tungstenOre = new BlockTungstenOre("tungstenOre", Material.rock), "tungstenOre");
    }
}
