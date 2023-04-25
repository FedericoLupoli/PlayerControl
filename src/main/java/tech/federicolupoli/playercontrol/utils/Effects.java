package tech.federicolupoli.playercontrol.utils;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;

import static tech.federicolupoli.playercontrol.fullbright.fullbrightInputHandler.fullbrightStatus;

public class Effects {
    private static void addPermEffect(ClientPlayerEntity player, StatusEffect effect) {
        StatusEffectInstance statusEffect = new StatusEffectInstance(effect,-1,0,false,false,false);
        player.addStatusEffect(statusEffect);
    }

    public static void enableNightVision(ClientPlayerEntity player){
        addPermEffect(player, StatusEffects.NIGHT_VISION);
        fullbrightStatus=true;
        player.sendMessage(Text.of("Fullbright ON"));
    }

    public static void disableNightVision(ClientPlayerEntity player) {
        player.removeStatusEffect(StatusEffects.NIGHT_VISION);
        fullbrightStatus = false;
        player.sendMessage(Text.of("Fullbright OFF"));
    }
}
