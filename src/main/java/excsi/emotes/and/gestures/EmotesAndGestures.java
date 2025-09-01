package excsi.emotes.and.gestures;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import excsi.emotes.and.gestures.common.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = EmotesAndGestures.MODID, name = EmotesAndGestures.NAME, version = EmotesAndGestures.VERSION)
public class EmotesAndGestures {

    public static final String MODID = "Emotes";

    public static final String NAME = "Emotes & Gestures";

    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide = "excsi.emotes.and.gestures.client.ClientProxy", serverSide = "excsi.emotes.and.gestures.common.CommonProxy")
    public static CommonProxy proxy;

    public static final Logger LOG = LogManager.getLogger(MODID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
}
