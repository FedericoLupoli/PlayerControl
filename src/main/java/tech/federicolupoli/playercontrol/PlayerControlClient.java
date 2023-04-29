package tech.federicolupoli.playercontrol;

import net.fabricmc.api.ClientModInitializer;

import tech.federicolupoli.playercontrol.fly.flyInputHandler;
import tech.federicolupoli.playercontrol.fly.flySpeedModifier;
import tech.federicolupoli.playercontrol.fullbright.fullbrightInputHandler;

public class PlayerControlClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        fullbrightInputHandler.register();
        flyInputHandler.register();
        flySpeedModifier.registerUP();
        flySpeedModifier.registerDOWN();
    }
}
