package tech.federicolupoli.playercontrol.fullbright;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import static tech.federicolupoli.playercontrol.keyCategory.KEY_CATEGORY_PLAYERCONTROL;
import static tech.federicolupoli.playercontrol.keyCategory.KEY_FULLBRIGHT;
import static tech.federicolupoli.playercontrol.fullbright.Effects.disableNightVision;
import static tech.federicolupoli.playercontrol.fullbright.Effects.enableNightVision;

public class fullbrightInputHandler {
    public static boolean fullbrightStatus = false;
    private static KeyBinding fullbrightKey;

    public static void registerkeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (fullbrightKey.wasPressed()){
                if (!fullbrightStatus){
                    enableNightVision(client.player);
                }else {
                    disableNightVision(client.player);
                }
            }
        });
    }

    public static void register() {
        fullbrightKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FULLBRIGHT,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_X,
                KEY_CATEGORY_PLAYERCONTROL
        ));
        registerkeyInputs();
    }
}
