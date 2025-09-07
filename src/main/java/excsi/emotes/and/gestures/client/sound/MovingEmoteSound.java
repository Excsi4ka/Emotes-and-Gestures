package excsi.emotes.and.gestures.client.sound;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import excsi.emotes.and.gestures.client.render.EmoteProgressWrapper;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public abstract class MovingEmoteSound extends MovingSound {

    public EmoteProgressWrapper emoteProgress;

    public BasicEmote emote;

    public MovingEmoteSound(EmoteProgressWrapper wrapper, ResourceLocation resourceLocation) {
        super(resourceLocation);
        this.emoteProgress = wrapper;
        this.emote = emoteProgress.getEmote();
    }

    @Override
    public void update() {
        if(emoteProgress.doneEmoting()) {
            donePlaying = true;
            return;
        }
        if(emote != emoteProgress.getEmote()) {
            donePlaying = true;
            return;
        }
        EntityPlayer player = emoteProgress.getPlayer();
        if (player == null || player.isDead) {
            donePlaying = true;
        } else {
            this.xPosF = (float) player.posX;
            this.yPosF = (float) player.posY;
            this.zPosF = (float) player.posZ;
        }
    }
}
