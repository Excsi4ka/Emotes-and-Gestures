package excsi.emotes.and.gestures.client.render.gestures;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class BowEmote extends BasicEmote {

    public BowEmote(String name, int emoteTime, ResourceLocation texture) {
        super(name, emoteTime, texture);
    }

    @Override
    public void transformModel(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        float time = getMaxEmoteTime() * 0.2f;
        float partialTime = (Math.min(timeElapsed + partialTicks, time)) / time;
        model.bipedBody.rotateAngleX = 0.35f * partialTime;
        model.bipedBody.offsetZ = -0.25f * partialTime;
        model.bipedBody.offsetY = 0.1f * partialTime;

        model.bipedCloak.rotateAngleX = -model.bipedBody.rotateAngleX;
        model.bipedCloak.offsetZ = -model.bipedBody.offsetZ;
        model.bipedCloak.offsetY = model.bipedBody.offsetY;

        model.bipedHead.rotateAngleX = 0.8f * partialTime;
        model.bipedHead.offsetZ = model.bipedBody.offsetZ;
        model.bipedHead.offsetY = model.bipedBody.offsetY;

        model.bipedHeadwear.rotateAngleX = model.bipedHead.rotateAngleX;
        model.bipedHeadwear.offsetZ = model.bipedHead.offsetZ;
        model.bipedHeadwear.offsetY = model.bipedHead.offsetY;

        model.bipedLeftArm.rotateAngleZ = 1.1f * partialTime;
        model.bipedLeftArm.rotateAngleX = -0.3f * partialTime;
        model.bipedLeftArm.offsetZ = model.bipedBody.offsetZ;
        model.bipedLeftArm.offsetY = model.bipedBody.offsetY;

        model.bipedRightArm.rotateAngleZ = 0.1f * partialTime;
        model.bipedRightArm.rotateAngleX = 0.8f * partialTime;
        model.bipedRightArm.offsetZ = model.bipedBody.offsetZ;
        model.bipedRightArm.offsetY = model.bipedBody.offsetY;
    }
}
