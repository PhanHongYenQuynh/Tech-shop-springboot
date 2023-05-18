package com.shoptech.admin.setting;

import com.shoptech.entity.Setting;
import com.shoptech.entity.SettingCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SettingRepository extends CrudRepository<Setting,String> {
    public List<Setting> findByCategory(SettingCategory category);
}
