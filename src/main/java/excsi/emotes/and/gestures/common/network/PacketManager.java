package excsi.emotes.and.gestures.common.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import excsi.emotes.and.gestures.EmotesAndGestures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class PacketManager {

    public static SimpleNetworkWrapper WRAPPER = NetworkRegistry.INSTANCE.newSimpleChannel(EmotesAndGestures.MODID);

    public static void register() {
        int id = 0;
        WRAPPER.registerMessage(ClientSendEmote.class, ClientSendEmote.class, id++, Side.SERVER);
        WRAPPER.registerMessage(ServerSendEmote.class, ServerSendEmote.class, id++, Side.CLIENT);
    }

    public static void sendToServer(IMessage message) {
        WRAPPER.sendToServer(message);
    }

    public static void sendToPlayer(IMessage message, EntityPlayer player) {
        WRAPPER.sendTo(message, (EntityPlayerMP) player);
    }
}
