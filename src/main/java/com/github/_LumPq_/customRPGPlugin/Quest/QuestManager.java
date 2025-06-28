package com.github._LumPq_.customRPGPlugin.Quest;

import com.github._LumPq_.customRPGPlugin.CustomRPGPlugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class QuestManager {
    private static final List<YamlConfiguration> questList = new ArrayList<>();

    public static void reloadAll() {
        questList.clear();

        File questFolder = new File(CustomRPGPlugin.getInstance().getDataFolder().getParentFile(), "Quests");
        if (!questFolder.exists()) {
            questFolder.mkdirs(); // 없으면 생성
        }

        File[] files = questFolder.listFiles((dir, name) -> name.endsWith(".yml"));
        if (files == null) return;

        for (File file : files) {
            try {
                YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                questList.add(config);
            } catch (Exception e) {
                CustomRPGPlugin.getInstance().getLogger().warning("퀘스트 파일 로딩 실패: " + file.getName() + " - " + e.getMessage());
            }
        }
    }

    public static List<YamlConfiguration> getAllQuests() {
        return questList;
    }

    public static int getLoadedCount() {
        return questList.size();
    }

    public static YamlConfiguration findQuestById(String id) {
        for (YamlConfiguration quest : questList) {
            String questId = quest.getString("id");
            if (id.equalsIgnoreCase(questId)) {
                return quest;
            }
        }
        return null;
    }
}
