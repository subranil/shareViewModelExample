package com.subranil.sharedviewmodelexample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.subranil.sharedviewmodelexample.databinding.FragmentFirstBinding
import com.subranil.sharedviewmodelexample.network.AuthApi
import com.subranil.sharedviewmodelexample.repository.AuthRepository
import com.subranil.sharedviewmodelexample.ui.base.BaseFragment
import com.subranil.sharedviewmodelexample.viewmodel.SharedViewModel

class FirstFragment : BaseFragment<SharedViewModel, FragmentFirstBinding, AuthRepository>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.saveCountry("")
    }

    override fun getViewModel() = SharedViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFirstBinding = FragmentFirstBinding.inflate(layoutInflater, container, false)

    override fun getRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))

}