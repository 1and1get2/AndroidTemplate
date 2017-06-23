package com.tailoredapps.template.ui.main.viewpager

import android.content.res.Resources
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.tailoredapps.template.R
import com.tailoredapps.template.injection.qualifier.ActivityFragmentManager
import com.tailoredapps.template.injection.scopes.PerActivity
import com.tailoredapps.template.ui.main.viewpager.all.AllCountriesFragment
import com.tailoredapps.template.ui.main.viewpager.favorites.FavoriteCountriesFragment

import javax.inject.Inject

/* Copyright 2016 Patrick Löwenstein
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

@PerActivity
class MainAdapter
@Inject
constructor(@ActivityFragmentManager fm: FragmentManager, private val res: Resources) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> AllCountriesFragment()
            else -> FavoriteCountriesFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return res.getString(
                when(position) {
                    0 -> R.string.tab_title_all
                    else -> R.string.tab_title_favorites
                }
        );
    }

    override fun getCount(): Int {
        return 2
    }
}
