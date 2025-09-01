package excsi.emotes.and.gestures.common;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import excsi.emotes.and.gestures.common.network.PacketManager;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Config.loadConfig(event.getSuggestedConfigurationFile());
        PacketManager.register();
    }
}
