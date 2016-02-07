package com.mrburgerus.ImmersiveArms.entities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;


public class EntityBullet extends EntityThrowable
{
    //fields
    float damage = 5F;

    //constructors
    public EntityBullet(World world) {
        super(world);
    }

    public EntityBullet(World world, EntityPlayer player)
    {
        super(world, player);
    }

    //methods
    @Override
    protected void onImpact(MovingObjectPosition movingPos) {
        if (movingPos.entityHit != null)
        {
            movingPos.entityHit.attackEntityFrom(DamageSource.generic, damage);
        }
        worldObj.spawnParticle("note", posX, posY, posZ, 0.0F, 0.0F, 0.0F);
        this.setDead();
    }

    @Override
    protected float getGravityVelocity() {
        return 0.0F;
    }

    @Override
    public void setThrowableHeading(double x, double y, double z, float speed, float deviation)
    {
        float f2 = MathHelper.sqrt_double(x * x + y * y + z * z);
        x /= f2;
        y /= f2;
        z /= f2;
        x += rand.nextGaussian() * 0.0075F * deviation;
        y += rand.nextGaussian() * 0.0075F * deviation;
        z += rand.nextGaussian() * 0.0075F * deviation;
        x *= speed;
        y *= speed;
        z *= speed;
        motionX = x;
        motionY = y;
        motionZ = z;
        float f3 = MathHelper.sqrt_double(x * x + z * z);
        prevRotationYaw = rotationYaw = (float) ((Math.atan2(x, z) * 180D) / Math.PI);
        prevRotationPitch = rotationPitch = (float) ((Math.atan2(y, f3) * 180D) / Math.PI);
    }

    @Override
    public void setVelocity(double d, double d1, double d2)
    {
        motionX = d;
        motionY = d1;
        motionZ = d2;
        if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(d * d + d2 * d2);
            prevRotationYaw = rotationYaw = (float) ((Math.atan2(d, d2) * 180D) / Math.PI);
            prevRotationPitch = rotationPitch = (float) ((Math.atan2(d1, f) * 180D) / Math.PI);
            setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
        }
    }

    public void setDamage(float dmg)
    {
        damage = dmg;
    }
}
