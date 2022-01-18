package com.subranil.sharedviewmodelexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.subranil.sharedviewmodelexample.R
import com.subranil.sharedviewmodelexample.databinding.FragmentSecondBinding
import com.subranil.sharedviewmodelexample.viewmodel.SharedViewModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)

        sharedViewModel.country.observe(viewLifecycleOwner, {
            binding.secondFragmentEditText.setText(it)
        })

        binding.secondFragmentSave.setOnClickListener {
            sharedViewModel.saveCountry(binding.secondFragmentEditText.text.toString())
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }
        return binding.root
    }
}