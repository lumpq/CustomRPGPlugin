package com.github._LumPq_.customRPGPlugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import com.github._LumPq_.customRPGPlugin.Quest.QuestManager;

public class CRPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
        String type = args[0];
        switch (type) {
            case "quest":
                String action = args[1];
                switch (action) {
                    case "reload":
                        QuestManager.reloadAll();
                        break;
                }
            }
            break;
        }
        return true;
    }
}
