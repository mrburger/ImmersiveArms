package com.mrburgerus.ImmersiveArms.entities;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;


public class EntityBullet extends EntityThrowable
{
    //fields
    float damage = 100F;

    //constructors
    public EntityBullet(World world) {
        super(world);
    }

    //methods
    @Override
    protected void onImpact(MovingObjectPosition movingPos)
    {
        if (movingPos.entityHit != null)
        {

            movingPos.entityHit.attackEntityFrom(DamageSource.generic, damage);

        }
        worldObj.spawnParticle("largesmoke", posX, posY, posZ, 0.0F, 0.0F, 0.0F);
        this.setDead();
    }
}
