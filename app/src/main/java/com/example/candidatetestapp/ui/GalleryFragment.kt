package com.example.candidatetestapp.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.candidatetestapp.R
import com.example.candidatetestapp.adapters.GalleryPageAdapter
import com.example.candidatetestapp.databinding.FragmentGalleryBinding
import com.example.candidatetestapp.models.Photo
import com.example.candidatetestapp.utils.PhotoConverters
import com.example.candidatetestapp.viewmodel.PhotoViewModel
import kotlinx.coroutines.launch

class GalleryFragment : Fragment() {
    private lateinit var binding: FragmentGalleryBinding
    private val PICK_IMAGE_CODE = 100
    private lateinit var viewModel: PhotoViewModel
    private lateinit var adapter: GalleryPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)

        binding.galleryFloatingBtn.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(gallery, PICK_IMAGE_CODE)
        }

        adapter = GalleryPageAdapter()
        binding.galleryRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.galleryRecyclerView.adapter = adapter

        viewModel.photoData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE_CODE) {
            val imageUri = data?.data
            val bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver, imageUri)
            lifecycleScope.launch {
                viewModel.insertPhoto(Photo(photoBmp = bitmap))
            }
        }
    }
}