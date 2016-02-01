package com.mrburgerus.ImmersiveArms.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public abstract class EntityBase extends EntityArrow
{
    //fields

    //constructors
    public EntityBase(World world)
    {
        super(world);
        renderDistanceWeight=10;
        setSize(0.125f, 0.125f);

    }

    public EntityBase(World world, double x, double y, double z, double ax, double ay, double az)
    {
        super(world);
        this.setSize(0.125F, 0.125F);
        this.setLocationAndAngles(x, y, z, this.rotationYaw, this.rotationPitch);
        this.setPosition(x, y, z);
    }


}
