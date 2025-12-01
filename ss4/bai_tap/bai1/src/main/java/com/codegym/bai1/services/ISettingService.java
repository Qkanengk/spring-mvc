package com.codegym.bai1.services;

import com.codegym.bai1.entities.Setting;

import java.util.List;

public interface ISettingService {
    List<Setting> findAll();
    boolean add(Setting setting);
    boolean update(Setting setting, Integer id);
    Setting findById(Integer id);

}
