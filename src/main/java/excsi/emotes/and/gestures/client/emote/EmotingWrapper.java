package excsi.emotes.and.gestures.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;

public class EmotingWrapper {

    private BasicEmote emote;

    private int timeElapsed = 0;

    public EmotingWrapper(BasicEmote emote) {
        this.emote = emote;
    }

    public void update(BasicEmote emote) {
        this.emote = emote;
        this.timeElapsed = 0;
    }

    public void tick() {
        timeElapsed++;
    }

    public boolean doneEmoting() {
        return timeElapsed > emote.getMaxEmoteTime();
    }

    public void render(EntityPlayer player, ModelBiped modelBiped, float partialTicks) {
        emote.renderEmote(player, modelBiped, timeElapsed, partialTicks);
    }
}
