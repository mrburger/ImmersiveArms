package com.mrburgerus.ImmersiveArms.world;

import com.mrburgerus.ImmersiveArms.item.blocks.Blocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class GenOres implements IWorldGenerator
{
    private WorldGenerator genVanadium;
    private WorldGenerator genChromium;
    private WorldGenerator genTungsten;

    public GenOres() {
        this.genVanadium = new WorldGenMinable(Blocks.vanadiumOre, 2);
        this.genChromium = new WorldGenMinable(Blocks.chromiumOre, 5);
        this.genTungsten = new WorldGenMinable(Blocks.tungstenOre, 8);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {

            case 0:
                this.generateOre(this.genVanadium, world, random, chunkX, chunkZ, 7, 32, 34);
                this.generateOre(this.genChromium, world, random, chunkX, chunkZ, 5, 24, 40);
                this.generateOre(this.genTungsten, world, random, chunkX, chunkZ, 2 , 2, 10);
                break;

            case -1:

                break;

            case 1:

                break;


        }
    }



    private void generateOre(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, x, y, z);
        }
    }
}
