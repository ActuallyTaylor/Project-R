package net.ProjectR.mixin;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.LocateCommand;
import net.minecraft.server.command.ServerCommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
 
import static net.minecraft.server.command.CommandManager.literal;
 
@Mixin(LocateCommand.class)
public abstract class LocateCommandMixin {
 
    private LocateCommandMixin() {
        // NO-OP
    }
 
    @Shadow
    private static int execute(ServerCommandSource source, String name) {
        throw new AssertionError();
    }
 
    @Inject(method = "register", at = @At(value = "RETURN"))
    private static void onRegister(CommandDispatcher<ServerCommandSource> dispatcher, CallbackInfo info) {
        dispatcher.register(literal("locate").requires(source -> source.hasPermissionLevel(2)).then(literal("Ruin_1").executes(ctx -> execute(ctx.getSource(), "ruins_1"))));
        dispatcher.register(literal("locate").requires(source -> source.hasPermissionLevel(2)).then(literal("Ruin_2").executes(ctx -> execute(ctx.getSource(), "ruins_2"))));
        dispatcher.register(literal("locate").requires(source -> source.hasPermissionLevel(2)).then(literal("Ruin_3").executes(ctx -> execute(ctx.getSource(), "ruins_3"))));
        dispatcher.register(literal("locate").requires(source -> source.hasPermissionLevel(2)).then(literal("Dungeon_1").executes(ctx -> execute(ctx.getSource(), "dungeon_1"))));
        dispatcher.register(literal("locate").requires(source -> source.hasPermissionLevel(2)).then(literal("Dungeon_2").executes(ctx -> execute(ctx.getSource(), "dungeon_2"))));

    }
}