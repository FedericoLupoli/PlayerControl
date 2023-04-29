package tech.federicolupoli.playercontrol.fly;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import static tech.federicolupoli.playercontrol.fly.flyInputHandler.flyStatus;
import static tech.federicolupoli.playercontrol.fly.flyMethod.*;
import static tech.federicolupoli.playercontrol.keyCategory.*;

public class flySpeedModifier {
    private static KeyBinding speedKeyUP;
    private static KeyBinding speedKeyDOWN;

    public static void registerkeyInputs1(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (speedKeyUP.wasPressed()){
                assert client.player != null;
                flySpeedUP(client.player);
            }
        });
    }



    public static void registerUP() {
        speedKeyUP = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FLY_SPEED_UP,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                KEY_CATEGORY_PLAYERCONTROL
        ));
        registerkeyInputs1();
    }

    public static void registerkeyInputs2(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (speedKeyDOWN.wasPressed()){
                flySpeedDOWN(client.player);
            }
        });
    }



    public static void registerDOWN() {
        speedKeyDOWN = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FLY_SPEED_DOWN,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                KEY_CATEGORY_PLAYERCONTROL
        ));
        registerkeyInputs2();
    }
}
