package excsi.emotes.and.gestures.client;

import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderHelper {

    public static void drawFullSizeTexturedRectangle(int x, int y, int width, int height, float zOffset) {
        Tessellator tes = Tessellator.instance;
        tes.startDrawingQuads();
        tes.addVertexWithUV(x + width,y + height,zOffset,1,1);
        tes.addVertexWithUV(x + width,y,zOffset,1,0);
        tes.addVertexWithUV(x,y,zOffset,0,0);
        tes.addVertexWithUV(x,y + height,zOffset,0,1);
        tes.draw();
    }

    public static void drawBackgroundSquare(int x, int y, int width, int height, int z) {
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        Tessellator tes = Tessellator.instance;
        tes.startDrawingQuads();
        tes.setColorRGBA(17,17,17, 150);
        tes.addVertex(x + width,y + height,z);
        tes.addVertex(x + width,y,z);
        tes.addVertex(x,y,z);
        tes.addVertex(x,y + height,z);
        tes.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

}
