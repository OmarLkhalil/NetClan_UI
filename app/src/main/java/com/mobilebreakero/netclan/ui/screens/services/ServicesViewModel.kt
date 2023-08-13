package com.mobilebreakero.netclan.ui.screens.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ServicesViewModel : ViewModel() {

    private val _progress = MutableLiveData<Int>().apply {
        value = 20
    }

    val progress: LiveData<Int> = _progress


    fun setProgress(newProgress: Int) {
        _progress.value = newProgress
    }
}