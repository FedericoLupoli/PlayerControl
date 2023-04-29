package tech.federicolupoli.playercontrol.fly;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;

import static net.minecraft.entity.damage.DamageTypes.FALL;
import static tech.federicolupoli.playercontrol.fly.flyInputHandler.flyStatus;

public class flyMethod {
    public static void allowFlight(ClientPlayerEntity player){
        flyStatus = true;
        player.getAbilities().allowFlying=true;
        player.sendMessage(Text.of("Fly ON"));
        player.sendAbilitiesUpdate();
    }

    public static void disableFlight(ClientPlayerEntity player) {
        flyStatus = false;
        player.getAbilities().allowFlying = false;
        player.getAbilities().flying = false;
        player.sendMessage(Text.of("Fly OFF"));
        player.sendAbilitiesUpdate();
    }

    public static void flySpeedUP(ClientPlayerEntity player){
        float flySpeed = player.getAbilities().getFlySpeed();
        player.getAbilities().setFlySpeed(flySpeed + 0.1F);
        player.sendMessage(Text.of("Fly speed is now: " + flySpeed));
    }

    public static void flySpeedDOWN(ClientPlayerEntity player){
        float flySpeed = player.getAbilities().getFlySpeed();
        player.getAbilities().setFlySpeed(flySpeed - 0.1F);
        player.sendMessage(Text.of("Fly speed is now: " + flySpeed));
    }

}
