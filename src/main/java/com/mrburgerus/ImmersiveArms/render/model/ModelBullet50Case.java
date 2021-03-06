// Date: 2/8/2016 4:29:25 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.mrburgerus.ImmersiveArms.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBullet50Case extends ModelBase
{
  //fields
    ModelRenderer Bottom;
    ModelRenderer Dent;
    ModelRenderer Case;
    ModelRenderer Neck;
  
  public ModelBullet50Case()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Bottom = new ModelRenderer(this, 0, 0);
      Bottom.addBox(0F, 5F, 0F, 6, 1, 6);
      Bottom.setRotationPoint(0F, 0F, 0F);
      Bottom.setTextureSize(64, 32);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      Dent = new ModelRenderer(this, 0, 0);
      Dent.addBox(0.5F, 4F, 0.5F, 5, 1, 5);
      Dent.setRotationPoint(0F, 0F, 0F);
      Dent.setTextureSize(64, 32);
      Dent.mirror = true;
      setRotation(Dent, 0F, 0F, 0F);
      Case = new ModelRenderer(this, 0, 0);
      Case.addBox(0F, -15.5F, 0F, 6, 20, 6);
      Case.setRotationPoint(0F, 0F, 0F);
      Case.setTextureSize(64, 32);
      Case.mirror = true;
      setRotation(Case, 0F, 0F, 0F);
      Neck = new ModelRenderer(this, 0, 0);
      Neck.addBox(0.5F, -20F, 0.5F, 5, 5, 5);
      Neck.setRotationPoint(0F, 0F, 0F);
      Neck.setTextureSize(64, 32);
      Neck.mirror = true;
      setRotation(Neck, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Bottom.render(f5);
    Dent.render(f5);
    Case.render(f5);
    Neck.render(f5);
  }

  public void renderModel(float f5)
  {
    Bottom.render(f5);
    Dent.render(f5);
    Case.render(f5);
    Neck.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
