package com.codegym.bai1.services;

import com.codegym.bai1.entities.Setting;
import com.codegym.bai1.repositories.ISettingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService implements ISettingService{
    private ISettingRepository settingRepository;
    public SettingService(ISettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Override
    public List<Setting> findAll() {
        return settingRepository.findAll();
    }

    @Override
    public boolean add(Setting setting) {
        return settingRepository.add(setting);
    }

    @Override
    public boolean update(Setting setting, Integer id) {
        return settingRepository.update(setting,id);
    }

    @Override
    public Setting findById(Integer id) {
        return settingRepository.findById(id);
    }
}
