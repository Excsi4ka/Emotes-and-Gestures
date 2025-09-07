package excsi.emotes.and.gestures.client.render.gestures;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CelebrateEmote extends BasicEmote {

    public CelebrateEmote(String name, int emoteTime, ResourceLocation texture) {
        super(name, emoteTime, texture);
    }

    @Override
    public void transformModel(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        float move = MathHelper.sin((timeElapsed + partialTicks)) * 0.2f;
        model.bipedRightArm.rotateAngleZ = -0.2f;
        model.bipedRightArm.rotateAngleX = 3.35f + move;
        model.bipedLeftArm.rotateAngleZ = -model.bipedRightArm.rotateAngleZ;
        model.bipedLeftArm.rotateAngleX = model.bipedRightArm.rotateAngleX;
    }
}
