package net.impleri.playerskills.variant.basic;

import net.impleri.playerskills.api.Skill;
import net.impleri.playerskills.api.TeamMode;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BasicSkill extends Skill<Boolean> {
    public BasicSkill(ResourceLocation name, @Nullable Boolean value, @Nullable String description, List<Boolean> options, int changesAllowed, TeamMode teamMode, boolean notify, String notifyKey) {
        super(name, BasicSkillType.name, value, description, options, changesAllowed, teamMode, notify, notifyKey);
    }

    @Override
    public Skill<Boolean> copy(Boolean value, int changesAllowed) {
        return new BasicSkill(name, value, description, options, changesAllowed, teamMode, notify, notifyKey);
    }

    @Override
    @Nullable
    protected Component getDefaultNotification() {
        var messageKey = value ? "playerskills.notify.basic_skill_enabled" : "playerskills.notify.basic_skill_disabled";
        var skillName = formatSkillName();

        return Component.translatable(messageKey, skillName);
    }
}
