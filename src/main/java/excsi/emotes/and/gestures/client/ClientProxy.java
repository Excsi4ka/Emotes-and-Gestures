package excsi.emotes.and.gestures.client;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import excsi.emotes.and.gestures.client.emote.BasicEmote;
import excsi.emotes.and.gestures.client.emote.EmoteRegistry;
import excsi.emotes.and.gestures.client.emote.EmoteRenderer;
import excsi.emotes.and.gestures.client.gui.EmoteButton;
import excsi.emotes.and.gestures.common.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;

import java.util.Collection;

public class ClientProxy extends CommonProxy {

    public static int previousPOV;

    public static int timeLeft;

    public static boolean needsToRevert = false;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);

        EmoteRegistry.registerDefaults();
    }


    @SubscribeEvent
    @SuppressWarnings("unchecked")
    public void onGuiInit(GuiScreenEvent.InitGuiEvent event) {
        if(event.gui instanceof GuiChat) {
            GuiChat chat = (GuiChat) event.gui;
            int x = chat.width;
            int y = chat.height;
            Collection<BasicEmote> emotes = EmoteRegistry.getAllEmotes();
            int i = 0, j = 0;
            for (BasicEmote emote : emotes) {
                event.buttonList.add(new EmoteButton(emote, x - 19 - 19 * i++, y - 34 - 19 * j, 15, 15));
                j = i == 5 ? ++j : j;
                i %= 5;
            }
        }
    }

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event) {
        if(event.phase == TickEvent.Phase.START)
            return;
        EmoteRenderer.emotingPlayers.values().forEach(wrapper -> {
            if(wrapper.doneEmoting())
                return;
            wrapper.tick();
        });
        if(!needsToRevert)
            return;
        if(timeLeft-- <= 0) {
            needsToRevert = false;
            timeLeft = 0;
            Minecraft.getMinecraft().gameSettings.thirdPersonView = previousPOV;
        }
    }

    public static void startPOVChange(int pov, int time) {
        timeLeft = time;
        previousPOV = pov;
        needsToRevert = true;
    }
}
