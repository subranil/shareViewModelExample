package com.subranil.sharedviewmodelexample.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.subranil.sharedviewmodelexample.repository.BaseRepository
import com.subranil.sharedviewmodelexample.network.RemoteDataSource
import com.subranil.sharedviewmodelexample.viewmodel.ViewModelFactory

abstract class BaseFragment<VM : ViewModel, viewBinding : ViewBinding, repository : BaseRepository> :
    Fragment() {
    private lateinit var binding: viewBinding
    protected val remoteDataSource = RemoteDataSource()
    protected lateinit var viewModel: VM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(layoutInflater, container)
        val factory = ViewModelFactory(getRepository())
        viewModel = ViewModelProvider(this, factory)[getViewModel()]
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): viewBinding

    abstract fun getRepository(): repository
}