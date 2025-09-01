package excsi.emotes.and.gestures.client.emote;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public abstract class BasicEmote {

    private final String name;

    private final int maxEmoteTime;

    private final ResourceLocation texture;

    public BasicEmote(String name, int emoteTime, ResourceLocation texture) {
        this.name = name;
        this.maxEmoteTime = emoteTime;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getMaxEmoteTime() {
        return maxEmoteTime;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public abstract void renderEmote(EntityPlayer player, ModelBiped model, int timeElapsed, float partialTicks);
}
