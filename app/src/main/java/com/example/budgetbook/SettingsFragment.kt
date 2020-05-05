package com.example.budgetbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.Preference

import androidx.preference.PreferenceFragmentCompat


class SettingsFragment : PreferenceFragmentCompat(),Preference.OnPreferenceChangeListener{

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences,rootKey)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        return view
    }

    override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
        preference!!.summary = newValue.toString()
        return true
    }


}
