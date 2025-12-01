package com.codegym.bai1.repositories;

import com.codegym.bai1.entities.Setting;

import java.util.List;


public interface ISettingRepository {

    List<Setting> findAll();

    boolean add(Setting setting);

    boolean update(Setting setting, Integer id);

    Setting findById(Integer id);
}
