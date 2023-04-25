package tech.federicolupoli.playercontrol;

import net.fabricmc.api.ClientModInitializer;
import tech.federicolupoli.playercontrol.fullbright.fullbrightInputHandler;

public class PlayerControlClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        fullbrightInputHandler.register();
    }
}
