package excsi.emotes.and.gestures.client.gui;

import excsi.emotes.and.gestures.client.ClientProxy;
import excsi.emotes.and.gestures.client.RenderHelper;
import excsi.emotes.and.gestures.client.emote.BasicEmote;
import excsi.emotes.and.gestures.common.Config;
import excsi.emotes.and.gestures.common.network.ClientSendEmote;
import excsi.emotes.and.gestures.common.network.PacketManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class EmoteButton extends GuiButton {

    public final BasicEmote emote;

    public EmoteButton(BasicEmote emote, int x, int y, int width, int height) {
        super(-1, x, y, width, height, null);
        this.emote = emote;
    }

    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        //blinking text entering field is messing with colors
        GL11.glColor4f(1f, 1f, 1f, 1f);
        mc.getTextureManager().bindTexture(emote.getTexture());
        RenderHelper.drawFullSizeTexturedRectangle(xPosition, yPosition, width, height, 1);
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
    }

    @Override
    public void mouseReleased(int x, int y) {
        PacketManager.sendToServer(new ClientSendEmote(emote.getName()));
        if(Config.forcePOV) {
            ClientProxy.startPOVChange(Minecraft.getMinecraft().gameSettings.thirdPersonView, emote.getMaxEmoteTime());
            Minecraft.getMinecraft().gameSettings.thirdPersonView = Config.pointOfView;
        }
    }
}
