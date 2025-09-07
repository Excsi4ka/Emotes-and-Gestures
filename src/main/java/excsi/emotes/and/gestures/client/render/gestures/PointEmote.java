package excsi.emotes.and.gestures.client.render.gestures;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class PointEmote extends BasicEmote {

    public PointEmote(String name, int emoteTime, ResourceLocation texture) {
        super(name, emoteTime, texture);
    }

    @Override
    public void transformModel(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        float move = -(timeElapsed + partialTicks) * 0.35f;
        model.bipedRightArm.rotateAngleX = Math.max(move, -1.6f);
        model.bipedHead.offsetY = 0;
    }
}
