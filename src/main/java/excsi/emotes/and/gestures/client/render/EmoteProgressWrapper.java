package excsi.emotes.and.gestures.client.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;

public class EmoteProgressWrapper {

    private BasicEmote emote;

    private EntityPlayer player;

    private int timeElapsed = 0;

    private boolean doneEmoting;

    public EmoteProgressWrapper(EntityPlayer player, BasicEmote emote) {
        this.emote = emote;
        this.player = player;
        this.emote.onStartEmoting(this);
    }

    public void update(EntityPlayer player, BasicEmote emote) {
        this.emote = emote;
        this.timeElapsed = 0;
        this.doneEmoting = false;
        this.player = player;
        this.emote.onStartEmoting(this);
    }

    public void tick() {
        if(timeElapsed++ > emote.getMaxEmoteTime()) doneEmoting = true;
    }

    public EntityPlayer getPlayer() {
        return player;
    }

    public BasicEmote getEmote() {
        return emote;
    }

    public boolean doneEmoting() {
        return doneEmoting;
    }

    public void transformModel(EntityPlayer player, ModelBiped modelBiped, float partialTicks) {
        emote.transformModel(player, modelBiped, timeElapsed, partialTicks);
    }
}
