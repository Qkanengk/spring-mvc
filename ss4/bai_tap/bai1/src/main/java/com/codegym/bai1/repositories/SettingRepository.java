package com.codegym.bai1.repositories;

import com.codegym.bai1.entities.Setting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SettingRepository implements ISettingRepository {

    private final static List<Setting> settingList = new ArrayList<>();

    static {
        settingList.add(new Setting(1, "English", 10, true, "Best"));
        settingList.add(new Setting(2, "Vietnamese", 20, true, "Tốt"));
        settingList.add(new Setting(3, "Japanese", 25, true, "Best"));
        settingList.add(new Setting(4, "Chinese", 10, true, "Best"));
        settingList.add(new Setting(5, "Korean", 10, true, "Best"));
    }

    @Override
    public List<Setting> findAll() {
        return settingList;
    }

    @Override
    public boolean add(Setting setting) {
        return settingList.add(setting);
    }

    @Override
    public boolean update(Setting setting, Integer id) {
        Setting setting1 = findById(id);
        setting1.setLanguage(setting.getLanguage());
        setting1.setPageSize(setting.getPageSize());
        setting1.setSpamFilter(setting.isSpamFilter());
        setting1.setSignature(setting.getSignature());
        return true;
    }

    @Override
    public Setting findById(Integer id) {
        for (Setting setting : settingList) {
            if (setting.getId().equals(id)) return setting;
        }
        return null;
    }
}
