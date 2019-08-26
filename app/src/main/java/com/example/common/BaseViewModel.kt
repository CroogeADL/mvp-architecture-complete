package com.example.common

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.Repository

abstract class BaseViewModel(application: Application, protected var repository: Repository) :
    AndroidViewModel(application) {

    protected fun <T> LiveData<T>.setValue(value: T) {
        if (this is MutableLiveData<T>) this.value = value
    }

    protected fun <T> LiveData<T>.postValue(value: T) {
        if (this is MutableLiveData<T>) this.postValue(value)
    }
}