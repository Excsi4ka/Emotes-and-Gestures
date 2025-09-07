package excsi.emotes.and.gestures.client.render.gestures;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class FacePalmEmote extends BasicEmote {

    public FacePalmEmote(String name, int emoteTime, ResourceLocation texture) {
        super(name, emoteTime, texture);
    }

    @Override
    public void transformModel(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        float time = getMaxEmoteTime() * 0.3f;
        float partialTime = (Math.min(timeElapsed + partialTicks, time)) / time;

        model.bipedRightArm.rotateAngleY = -0.85f * partialTime;
        model.bipedRightArm.rotateAngleX = -2f * partialTime;

        model.bipedHead.rotateAngleX = 0.35f * partialTime;
        model.bipedHeadwear.rotateAngleX = model.bipedHead.rotateAngleX;
        model.bipedHead.rotateAngleY = 0;
        model.bipedHeadwear.rotateAngleY = 0;
    }
}
