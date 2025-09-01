package excsi.emotes.and.gestures.client.emote.gestures;

import excsi.emotes.and.gestures.client.emote.BasicEmote;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CelebrateEmote extends BasicEmote {

    public CelebrateEmote(String name, int emoteTime, ResourceLocation texture) {
        super(name, emoteTime, texture);
    }

    @Override
    public void renderEmote(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        float move = MathHelper.sin((timeElapsed + partialTicks)) * 0.2f;
        model.bipedRightArm.rotateAngleZ = -0.2f;
        model.bipedRightArm.rotateAngleX = 3.35f + move;
        model.bipedLeftArm.rotateAngleZ = 0.2f;
        model.bipedLeftArm.rotateAngleX = 3.35f + move;
    }
}
