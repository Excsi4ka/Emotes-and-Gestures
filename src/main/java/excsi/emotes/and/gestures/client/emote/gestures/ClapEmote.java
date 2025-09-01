package excsi.emotes.and.gestures.client.emote.gestures;

import excsi.emotes.and.gestures.client.emote.BasicEmote;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class ClapEmote extends BasicEmote {

    public ClapEmote(String name, int emoteTime, ResourceLocation texture) {
        super(name, emoteTime, texture);
    }

    @Override
    public void renderEmote(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        float move = MathHelper.sin((timeElapsed + partialTicks)) * 0.2f;
        model.bipedRightArm.rotateAngleY = -0.45f + move;
        model.bipedRightArm.rotateAngleX = 4.7f;
        model.bipedLeftArm.rotateAngleY = 0.45f - move;
        model.bipedLeftArm.rotateAngleX = 4.7f;
    }
}
