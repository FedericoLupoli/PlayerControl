package tech.federicolupoli.playercontrol.fly;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import org.lwjgl.glfw.GLFW;

import static tech.federicolupoli.playercontrol.fly.flyMethod.allowFlight;
import static tech.federicolupoli.playercontrol.fly.flyMethod.disableFlight;
import static tech.federicolupoli.playercontrol.keyCategory.*;

public class flyInputHandler {

    public static boolean flyStatus=false;
    private static KeyBinding flyKey;


    public static void registerkeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (flyKey.wasPressed()){
                if (!flyStatus){
                    assert client.player != null;
                    allowFlight(client.player);
                }else {
                    assert client.player != null;
                    disableFlight(client.player);
                }
            }
        });
    }

    public static void register() {
        flyKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_FLY,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                KEY_CATEGORY_PLAYERCONTROL
        ));
        registerkeyInputs();
    }

}
