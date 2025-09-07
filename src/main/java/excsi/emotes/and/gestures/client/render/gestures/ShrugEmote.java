package excsi.emotes.and.gestures.client.render.gestures;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class ShrugEmote extends BasicEmote {

    public ShrugEmote(String name, int emoteTime, ResourceLocation texture) {
        super(name, emoteTime, texture);
    }

    @Override
    public void transformModel(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks) {
        float move = MathHelper.sin((timeElapsed + partialTicks) * 0.2f) * 0.1f;
        model.bipedRightArm.rotateAngleZ = 0.2f;
        model.bipedLeftArm.rotateAngleZ = -model.bipedRightArm.rotateAngleZ;
        model.bipedRightArm.rotateAngleX = -0.35f;
        model.bipedLeftArm.rotateAngleX = -0.35f;
        model.bipedLeftArm.offsetY = -move;
        model.bipedRightArm.offsetY = -move;
    }
}
