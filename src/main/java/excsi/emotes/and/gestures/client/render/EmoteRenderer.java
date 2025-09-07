package excsi.emotes.and.gestures.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.UUID;

public class EmoteRenderer {

    public static HashMap<UUID, EmoteProgressWrapper> emotingPlayers = new HashMap<>();

    //hooks into model biped's setRotationAngles method
    public static void bipedRenderCallback(Entity entity, ModelBiped modelBiped) {
        if (!(entity instanceof EntityPlayer))
            return;

        EntityPlayer player = (EntityPlayer) entity;
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && player == Minecraft.getMinecraft().thePlayer)
            return;

        EmoteProgressWrapper handler = emotingPlayers.get(player.getUniqueID());
        if(handler == null || handler.doneEmoting())
            return;

        float partialTicks = Minecraft.getMinecraft().timer.renderPartialTicks;
        handler.transformModel(player, modelBiped, partialTicks);
    }

    public static void resetTransformations(Entity entity, ModelBiped modelBiped) {
        if (!(entity instanceof EntityPlayer))
            return;
        modelBiped.bipedBody.offsetZ = 0;
        modelBiped.bipedBody.offsetY = 0;
        modelBiped.bipedBody.offsetX = 0;

        modelBiped.bipedCloak.offsetZ = 0;
        modelBiped.bipedCloak.offsetY = 0;
        modelBiped.bipedCloak.offsetX = 0;
        modelBiped.bipedCloak.rotateAngleX = 0;

        modelBiped.bipedHeadwear.offsetZ = 0;
        modelBiped.bipedHeadwear.offsetY = 0;
        modelBiped.bipedHeadwear.offsetX = 0;
        modelBiped.bipedHeadwear.rotateAngleZ = 0;

        modelBiped.bipedHead.offsetZ = 0;
        modelBiped.bipedHead.offsetY = 0;
        modelBiped.bipedHead.offsetX = 0;
        modelBiped.bipedHead.rotateAngleZ = 0;

        modelBiped.bipedRightArm.offsetZ = 0;
        modelBiped.bipedRightArm.offsetY = 0;
        modelBiped.bipedRightArm.offsetX = 0;

        modelBiped.bipedLeftArm.offsetZ = 0;
        modelBiped.bipedLeftArm.offsetY = 0;
        modelBiped.bipedLeftArm.offsetX = 0;
    }
}
