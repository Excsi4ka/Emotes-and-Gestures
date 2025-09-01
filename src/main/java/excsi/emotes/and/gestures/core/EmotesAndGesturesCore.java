package excsi.emotes.and.gestures.core;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

@IFMLLoadingPlugin.Name(value = "EmotesAndGesturesCore")
@IFMLLoadingPlugin.TransformerExclusions({"excsi.emotes.and.gestures.core"})
@IFMLLoadingPlugin.SortingIndex(value = 1001)
public class EmotesAndGesturesCore implements IFMLLoadingPlugin {

    public static final Logger LOG = LogManager.getLogger("EmotesAndGesturesCore");

    public static Side SIDE = FMLLaunchHandler.side();

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{EmotesAndGesturesTransformer.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
