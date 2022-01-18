package com.subranil.sharedviewmodelexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subranil.sharedviewmodelexample.repository.BaseRepository
import com.subranil.sharedviewmodelexample.repository.AuthRepository

class ViewModelFactory(private val repository: BaseRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SharedViewModel::class.java) -> SharedViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModel class not found")
        }
    }
}