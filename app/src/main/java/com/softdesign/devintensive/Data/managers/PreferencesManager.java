package com.softdesign.devintensive.Data.managers;


import android.content.SharedPreferences;

import com.softdesign.devintensive.utils.ConstantManager;
import com.softdesign.devintensive.utils.DevintensiveApplication;

import java.util.ArrayList;
import java.util.List;

public class PreferencesManager {
    private SharedPreferences mSharedPreferences;

    private static final String[] USER_FIELD = {ConstantManager.USER_PHONE_KEY, ConstantManager.USER_MAIL_KEY, ConstantManager.USER_VK_KEY, ConstantManager.USER_GIT_KEY, ConstantManager.USER_BIO_KEY};

    public PreferencesManager() {
        mSharedPreferences = DevintensiveApplication.getSharedPreferences();
    }

    public void saveUserProfileData(List<String> userFilds) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        for (int i = 0; i < USER_FIELD.length; i++) {
            editor.putString(USER_FIELD[i], userFilds.get(i));
        }

        editor.apply();
    }

    public List<String> loadUserProfileData() {
        List<String> userFields = new ArrayList<>();
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_PHONE_KEY, null));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_MAIL_KEY, null));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_VK_KEY, null));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_GIT_KEY, null));
        userFields.add(mSharedPreferences.getString(ConstantManager.USER_BIO_KEY, null));
        return userFields;
           }

}

