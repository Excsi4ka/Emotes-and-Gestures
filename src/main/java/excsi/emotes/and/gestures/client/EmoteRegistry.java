package excsi.emotes.and.gestures.client;

import excsi.emotes.and.gestures.client.render.BasicEmote;
import excsi.emotes.and.gestures.client.render.gestures.BowEmote;
import excsi.emotes.and.gestures.client.render.gestures.FacePalmEmote;
import excsi.emotes.and.gestures.client.render.gestures.PointEmote;
import excsi.emotes.and.gestures.client.render.gestures.CelebrateEmote;
import excsi.emotes.and.gestures.client.render.gestures.ClapEmote;
import excsi.emotes.and.gestures.client.render.gestures.ShrugEmote;
import excsi.emotes.and.gestures.client.render.gestures.WaveEmote;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.HashMap;

public class EmoteRegistry {

    private static final HashMap<String, BasicEmote> registeredEmotes = new HashMap<>();

    public static void register(BasicEmote emote) {
        registeredEmotes.put(emote.getName(), emote);
    }

    public static Collection<BasicEmote> getAllEmotes() {
        return registeredEmotes.values();
    }

    public static BasicEmote getEmoteByID(String id) {
        return registeredEmotes.get(id);
    }

    public static void registerDefaults() {
        register(new WaveEmote("Wave", 50, rlDefault("wave.png")));
        register(new ClapEmote("Clap", 50, rlDefault("clap.png")));
        register(new CelebrateEmote("Celebrate", 50, rlDefault("cheer.png")));
        register(new ShrugEmote("Shrug", 15, rlDefault("clap.png")));
        register(new PointEmote("Point", 30, rlDefault("clap.png")));
        register(new BowEmote("Bow", 40, rlDefault("clap.png")));
        register(new FacePalmEmote("FacePalm", 40, rlDefault("clap.png")));
    }

    public static ResourceLocation rlDefault(String path) {
        return new ResourceLocation("emotes", "textures/gui/" + path);
    }
}
