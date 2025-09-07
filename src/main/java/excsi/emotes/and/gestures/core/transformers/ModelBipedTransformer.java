package excsi.emotes.and.gestures.core.transformers;

import cpw.mods.fml.relauncher.Side;
import excsi.emotes.and.gestures.core.AsmHelper;
import excsi.emotes.and.gestures.core.SubTransformer;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ModelBipedTransformer extends SubTransformer {

    public ModelBipedTransformer() {
        super("net.minecraft.client.model.ModelBiped");
    }

    @Override
    public boolean shouldApplyOnSide(Side side) {
        return side == Side.CLIENT;
    }

    @Override
    public void transformClass(ClassNode node) {
        MethodNode mn = AsmHelper.getMethodNodeByName(node, "setRotationAngles", "func_78087_a");
        AbstractInsnNode abstractInsnNode = AsmHelper.getFirstMatchingOpcode(mn, Opcodes.RETURN);
        mn.instructions.insertBefore(abstractInsnNode, new VarInsnNode(Opcodes.ALOAD, 7)); //entity
        mn.instructions.insertBefore(abstractInsnNode, new VarInsnNode(Opcodes.ALOAD, 0)); //this
        mn.instructions.insertBefore(abstractInsnNode, new MethodInsnNode(Opcodes.INVOKESTATIC,
                "excsi/emotes/and/gestures/client/render/EmoteRenderer",
                "bipedRenderCallback",
                "(Lnet/minecraft/entity/Entity;Lnet/minecraft/client/model/ModelBiped;)V",
                false));

        abstractInsnNode = mn.instructions.getFirst();
        mn.instructions.insertBefore(abstractInsnNode, new VarInsnNode(Opcodes.ALOAD, 7)); //entity
        mn.instructions.insertBefore(abstractInsnNode, new VarInsnNode(Opcodes.ALOAD, 0)); //this
        mn.instructions.insertBefore(abstractInsnNode, new MethodInsnNode(Opcodes.INVOKESTATIC,
                "excsi/emotes/and/gestures/client/render/EmoteRenderer",
                "resetTransformations",
                "(Lnet/minecraft/entity/Entity;Lnet/minecraft/client/model/ModelBiped;)V",
                false));
    }
}
