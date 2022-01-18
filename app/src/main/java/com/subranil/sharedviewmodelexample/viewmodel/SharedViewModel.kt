package com.subranil.sharedviewmodelexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.subranil.sharedviewmodelexample.repository.AuthRepository

class SharedViewModel(repository: AuthRepository) : ViewModel() {
     var currentCountryName = repository
    private var _country: MutableLiveData<String> = MutableLiveData()
    val country: LiveData<String>
        get() = _country

    init {
        print("the name of current country is $currentCountryName")
    }

    fun saveCountry(newCountry: String) {
        _country.value = newCountry
    }
}