package excsi.emotes.and.gestures.client.render.gestures;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class WaveEmote extends BasicEmote {

    public WaveEmote(String name, int maxEmoteTime, ResourceLocation texture) {
        super(name, maxEmoteTime, texture);
    }

    @Override
    public void transformModel(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        model.bipedRightArm.rotateAngleZ = MathHelper.sin((timeElapsed + partialTicks) * 0.65f) * 0.33f;
        model.bipedRightArm.rotateAngleX = 3.75f;
    }
}
