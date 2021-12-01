package de.dafuqs.starrysky.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import de.dafuqs.starrysky.Support;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;

import java.util.Optional;

public class ClosestSpheroidCommand implements Command<ServerCommandSource> {

    @Override
    public int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity caller = context.getSource().getPlayer();

        Optional<Support.SpheroidDistance> spheroidDistance = Support.getClosestSpheroidToPlayer(caller);

        if(spheroidDistance.isPresent()) {
            context.getSource().sendFeedback(new LiteralText("Closest Sphere:"), false);
            context.getSource().sendFeedback(new LiteralText(spheroidDistance.get().spheroid.getDescription()), false);
        } else {
            context.getSource().sendFeedback(new LiteralText("Could not determine closest sphere. :("), false);
        }

        return 1;
    }


}