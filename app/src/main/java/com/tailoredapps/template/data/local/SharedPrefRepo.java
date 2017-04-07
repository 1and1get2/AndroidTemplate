package com.tailoredapps.template.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;

import com.tailoredapps.template.injection.qualifier.AppContext;
import com.tailoredapps.template.injection.scopes.PerApplication;

import javax.inject.Inject;

/* Copyright 2017 Tailored Media GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */
@PerApplication
public class SharedPrefRepo implements PrefRepo {

    private static final String REALM_ENCRYPTION_KEY = "realm_encryption_key";

    private final SharedPreferences prefs;

    @Inject
    public SharedPrefRepo(@AppContext Context context) {
        this.prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void setRealmEncryptionKey(byte[] key) {
        prefs.edit().putString(REALM_ENCRYPTION_KEY, Base64.encodeToString(key, Base64.DEFAULT)).apply();
    }

    @Override
    public byte[] getRealmEncryptionKey() {
        if (prefs.contains(REALM_ENCRYPTION_KEY)) {
            return Base64.decode(prefs.getString(REALM_ENCRYPTION_KEY, null), Base64.DEFAULT);
        } else {
            return null;
        }
    }

}