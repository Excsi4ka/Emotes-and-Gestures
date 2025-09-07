package excsi.emotes.and.gestures.common.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.WorldServer;

import java.util.Set;

public class ClientSendEmote implements IMessage, IMessageHandler<ClientSendEmote, IMessage> {

    public String emoteID;

    public ClientSendEmote() {}

    public ClientSendEmote(String emoteID) {
        this.emoteID = emoteID;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        emoteID = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, emoteID);
    }

    @Override
    public IMessage onMessage(ClientSendEmote message, MessageContext ctx) {
        if(ctx.side == Side.SERVER) {

            EntityPlayer player = ctx.getServerHandler().playerEntity;
            if(player.worldObj instanceof WorldServer) {
                WorldServer worldServer = (WorldServer) player.worldObj;
                EntityTracker tracker = worldServer.getEntityTracker();
                Set<EntityPlayer> trackingPlayers = tracker.getTrackingPlayers(player);
                trackingPlayers.forEach(trackingPlayer -> PacketManager.sendToPlayer(new ServerSendEmote(message.emoteID, player.getEntityId()), trackingPlayer));
                //the player apparently isn't tracking itself so must notify the packet sender as well
                PacketManager.sendToPlayer(new ServerSendEmote(message.emoteID, player.getEntityId()), player);
            }
        }
        return null;
    }
}
