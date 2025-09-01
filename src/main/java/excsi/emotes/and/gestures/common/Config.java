package excsi.emotes.and.gestures.common;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class Config {

    public static Configuration CONFIG;

    public static String EMOTE_CATEGORY = "Emotes";

    public static int pointOfView;

    public static boolean forcePOV;

    public static void loadConfig(File file) {
        CONFIG = new Configuration(file);

        CONFIG.addCustomCategoryComment(EMOTE_CATEGORY, "Emote related settings");
        forcePOV = CONFIG.getBoolean("forcePOV", EMOTE_CATEGORY, true,
                "Should your point of view be changed when you start emoting");
        pointOfView = CONFIG.getInt("pointOfView", EMOTE_CATEGORY, 1, 0, 2,
                "Which point of view to set when you are emoting\n0 is first person, 1 is third person, 2 is third person from the front");

        CONFIG.save();
    }
}
