package com.example.candidatetestapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.candidatetestapp.databinding.FragmentGreeterBinding
import com.example.candidatetestapp.viewmodel.DataViewModel

class GreeterFragment : Fragment() {
    private lateinit var binding: FragmentGreeterBinding
    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGreeterBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        val user = viewModel.getData()
        Log.d("tag", "$user.age")
        binding.profileName.text = user.first_name + " " + user.second_name
        binding.profileEducation.text = when (user.education) {
            1 -> "High School Student"
            2 -> "Bachelor Student"
            3 -> "Master Student"
            4 -> "Doctor"
            else -> "Undefined"
        } + ", " + user.age

        Glide
            .with(this)
            .load(user.photo)
            .centerCrop()
            .into(binding.profileImage)

        return binding.root
    }
}