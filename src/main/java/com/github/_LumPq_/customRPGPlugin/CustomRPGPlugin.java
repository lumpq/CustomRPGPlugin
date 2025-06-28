package com.github._LumPq_.customRPGPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomRPGPlugin extends JavaPlugin {
    private static CustomRPGPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    public static CustomRPGPlugin getInstance() {
        return instance;
    }
}
