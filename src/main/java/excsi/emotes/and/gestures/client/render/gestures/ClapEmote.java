package excsi.emotes.and.gestures.client.render.gestures;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import excsi.emotes.and.gestures.client.render.EmoteProgressWrapper;
import excsi.emotes.and.gestures.client.sound.ClapEmoteSound;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class ClapEmote extends BasicEmote {

    public ClapEmote(String name, int emoteTime, ResourceLocation texture) {
        super(name, emoteTime, texture);
    }

    @Override
    public void transformModel(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        float move = MathHelper.sin((timeElapsed + partialTicks)) * 0.2f;
        model.bipedRightArm.rotateAngleY = -0.45f + move;
        model.bipedRightArm.rotateAngleX = 4.7f;
        model.bipedLeftArm.rotateAngleY = 0.45f - move;
        model.bipedLeftArm.rotateAngleX = 4.7f;
    }

    @Override
    public void onStartEmoting(EmoteProgressWrapper wrapper) {
        Minecraft.getMinecraft().getSoundHandler().playSound(new ClapEmoteSound(wrapper, new ResourceLocation("emotes","emote.clap")));
    }
}
