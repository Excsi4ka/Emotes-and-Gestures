package excsi.emotes.and.gestures.client.sound;

import excsi.emotes.and.gestures.client.render.EmoteProgressWrapper;
import net.minecraft.util.ResourceLocation;

public class ClapEmoteSound extends MovingEmoteSound {

    public ClapEmoteSound(EmoteProgressWrapper wrapper, ResourceLocation resourceLocation) {
        super(wrapper, resourceLocation);
        this.repeat = true;
        field_147665_h = 0;
    }
}
