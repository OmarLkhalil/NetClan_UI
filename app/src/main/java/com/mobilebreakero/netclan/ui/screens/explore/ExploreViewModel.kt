package com.mobilebreakero.netclan.ui.screens.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExploreViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is explore Fragment"
    }

    val text: LiveData<String> = _text

    fun setText(value: String) {
        _text.value = value
    }
}