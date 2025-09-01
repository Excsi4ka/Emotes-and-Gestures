package excsi.emotes.and.gestures.common.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import excsi.emotes.and.gestures.EmotesAndGestures;
import excsi.emotes.and.gestures.client.emote.BasicEmote;
import excsi.emotes.and.gestures.client.emote.EmoteRegistry;
import excsi.emotes.and.gestures.client.emote.EmoteRenderer;
import excsi.emotes.and.gestures.client.emote.EmotingWrapper;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ServerSendEmote implements IMessage, IMessageHandler<ServerSendEmote, IMessage> {

    public String emoteID;

    public int entityID;

    public ServerSendEmote() {}

    public ServerSendEmote(String emoteID, int entityID) {
        this.emoteID = emoteID;
        this.entityID = entityID;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        emoteID = ByteBufUtils.readUTF8String(buf);
        entityID = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, emoteID);
        buf.writeInt(entityID);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(ServerSendEmote message, MessageContext ctx) {
        if(ctx.side == Side.CLIENT) {
            Entity entity = Minecraft.getMinecraft().thePlayer.worldObj.getEntityByID(message.entityID);
            if(!(entity instanceof EntityPlayer))
                return null;
            EntityPlayer clientPlayer = (EntityPlayer) entity;
            BasicEmote emote = EmoteRegistry.getEmoteByID(message.emoteID);

            if(emote == null) {
                EmotesAndGestures.LOG.error("Unknown emote with ID: " + message.emoteID);
                return null;
            }

            EmotingWrapper handler = EmoteRenderer.emotingPlayers.get(clientPlayer.getUniqueID());
            if(handler == null)
                EmoteRenderer.emotingPlayers.put(clientPlayer.getUniqueID(), new EmotingWrapper(emote));
            else
                handler.update(emote);
        }
        return null;
    }
}
