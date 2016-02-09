package com.mrburgerus.ImmersiveArms.render.renderer;

import blusunrize.immersiveengineering.api.tool.IUpgradeableTool;
import com.mrburgerus.ImmersiveArms.ImmersiveArms;
import com.mrburgerus.ImmersiveArms.item.items.ItemSniperRifle;
import com.mrburgerus.ImmersiveArms.item.items.ItemWeapon;
import com.mrburgerus.ImmersiveArms.render.model.ModelSniperRifle;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RenderSniperRifle implements IItemRenderer {
    //fields
    static IModelCustom sniperRifle;
    public static ResourceLocation texture;

    //constructors
    public RenderSniperRifle()
    {
        sniperRifle = AdvancedModelLoader.loadModel(new ResourceLocation(ImmersiveArms.MODID + ":" + "models/ModelSniperRifle.obj"));
        texture = new ResourceLocation(ImmersiveArms.MODID + ":" + "textures/models/sniperRifle.png");
    }

    //methods
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {

        GL11.glPushMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON && Minecraft.getMinecraft().thePlayer.isSneaking())
        {
            GL11.glPopMatrix();
            return;
        }
        else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            float scale = 4F;
            GL11.glScalef(scale, scale, scale);
            //rotate upright
            GL11.glRotatef(180F, 1F, 0F, 0F);
            //rotate to be parallel with arm
            GL11.glRotatef(45F, 0F, -1F, 0F);
            //translate
            GL11.glTranslatef(1F, -0.1F, -0.1F);
            //fix OBJ
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(180F, 0F, 1F, 0F);
            GL11.glTranslatef(0F, -1.5F, -0.2F);
            GL11.glRotatef(10F, 0F, -1F, 0F);


        }
        else if (type == ItemRenderType.EQUIPPED)
        {

            float scale = 1.1F;
            GL11.glScalef(scale, scale, scale);
            //put upright
            GL11.glRotatef(180F, 0F, 0F, 1F);
            //align with arm side to side
            GL11.glRotatef(45F, 0F, 1F, 0F);
            //Put in hand
            GL11.glRotatef(70F, 0F, 0F, 1F);
            GL11.glTranslatef(0.5F, 0.6F, 0F);
            //fix OBJ


        }
        else if (type == ItemRenderType.ENTITY)
        {
            float scale = 1F;
            GL11.glScalef(scale, scale, scale);
            //rotate upright
            GL11.glRotatef(180F, 0F, 0F, 1F);


        }
        else if (type == ItemRenderType.INVENTORY)
        {
            float scale = 0.6F;
            GL11.glScalef(scale, scale, scale);
            //rotate upright
            GL11.glRotatef(180F, 0F, 0F, 1F);
            //translate into slot
            GL11.glTranslatef(0.1F, 0F, 0F);
            //fix OBJ
            GL11.glRotatef(180F, 1F, 0F, 0F);
            GL11.glRotatef(180F, 0F, 1F, 0F);
            GL11.glTranslatef(0F, -1F, 0F);


        }
        NBTTagCompound upgrades = ((ItemSniperRifle)item.getItem()).getUpgrades(item);
        if (upgrades.getBoolean("sniperSuppressor"))
        {
            sniperRifle.renderAll();
        }
        else
        {
            sniperRifle.renderAllExcept("Brake", "FrontSight");
        }

        GL11.glPopMatrix();
    }

}

