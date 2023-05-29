package com.shoptech.site.setting;

import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.shoptech.entity.Setting;
import com.shoptech.entity.SettingCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingService{
    @Autowired private SettingRepository repo;
//	@Autowired private CurrencyRepository currencyRepo;

    public List<Setting> getGeneralSettings() {
        return repo.findByTwoCategories(SettingCategory.GENERAL, SettingCategory.CURRENCY);
    }

    public EmailSettingBag getEmailSettings(){
        List<Setting> settings = repo.findByCategory((SettingCategory.MAIL_SERVER));
        settings.addAll(repo.findByCategory(SettingCategory.MAIL_TEMPLATES));
        return new EmailSettingBag(settings);
    }

    public List<Setting> getMailServerSettings() {
        return repo.findByCategory(SettingCategory.MAIL_SERVER);
    }

    public List<Setting> getMailTemplateSettings() {
        return repo.findByCategory(SettingCategory.MAIL_TEMPLATES);
    }

     public List<Setting> getCurrencySettings() {
        return repo.findByCategory(SettingCategory.CURRENCY);
    }

    public List<Setting> getPaymentSettings() {
        return repo.findByCategory(SettingCategory.PAYMENT);
    }
}
