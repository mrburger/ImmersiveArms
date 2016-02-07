package com.mrburgerus.ImmersiveArms.entities;

import blusunrize.immersiveengineering.common.entities.EntityIEProjectile;
import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBullet50 extends EntityBullet
{

    //fields
    private float speed = 7F;
    private float damage = 25F;

    //constructors
    public EntityBullet50(World world, EntityPlayer player) {
        super(world, player);
        setLocationAndAngles(player.posX, player.posY + player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
        motionX = -MathHelper.sin((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);
        motionZ = MathHelper.cos((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);
        motionY = -MathHelper.sin((rotationPitch / 180F) * 3.141593F);
        setThrowableHeading(motionX, motionY, motionZ, speed, 0.0F);
        this.setSize(.125F, .125F);
        this.setDamage(damage);
    }

    //methods
}