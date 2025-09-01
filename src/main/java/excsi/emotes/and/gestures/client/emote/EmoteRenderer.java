package excsi.emotes.and.gestures.client.emote;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import java.util.HashMap;
import java.util.UUID;

public class EmoteRenderer {

    public static HashMap<UUID, EmotingWrapper> emotingPlayers = new HashMap<>();

    //hooks into model biped's setRotationAngles method
    public static void bipedRenderCallback(Entity entity, ModelBiped modelBiped) {
        if (!(entity instanceof EntityPlayer))
            return;
        EntityPlayer player = (EntityPlayer) entity;
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && player == Minecraft.getMinecraft().thePlayer)
            return;
        EmotingWrapper handler = emotingPlayers.get(player.getUniqueID());
        if(handler == null || handler.doneEmoting()) {
            return;
        }
        float partialTicks = Minecraft.getMinecraft().timer.renderPartialTicks;
        handler.render(player, modelBiped, partialTicks);
    }
}
