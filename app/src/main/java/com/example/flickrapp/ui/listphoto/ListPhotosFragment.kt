package com.example.flickrapp.ui.listphoto

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flickrapp.R
import com.example.flickrapp.di.viewmodel.DaggerViewModelComponent
import com.example.flickrapp.ui.adapter.ListPhotoAdapter
import kotlinx.android.synthetic.main.list_photo_fragment.*
import javax.inject.Inject

class ListPhotosFragment : Fragment() {

    companion object {
        fun newInstance() = ListPhotosFragment()
        const val IMAGE_URL = "image_url"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ListPhotosViewModel
    private lateinit var adapter: ListPhotoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_photo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerViewModelComponent.create().inject(this)

        viewModel = ViewModelProvider(
                this,
                viewModelFactory
        ).get(ListPhotosViewModel::class.java)

        adapter =
                ListPhotoAdapter(
                        requireContext(),
                        mutableListOf(),
                        bigPhotoClickListener = {

                            val bundle = Bundle()
                            bundle.apply {
                                putString(IMAGE_URL, it.getFlickrImageLink('z'))
                            }
                        },
                        favorStarClickListener = {
                            Log.d("volttier", it.title!!)
//                            it.isFavorite = !it.isFavorite
//                            viewModel.switchFavorite(it)
//                            adapter.notifyDataSetChanged()
                        }
                )
        listPhotoRV.layoutManager = GridLayoutManager(context, 2)
        listPhotoRV.adapter = adapter

        viewModel.getPhoto("Moon")
        viewModel.photos.observe(
                viewLifecycleOwner,
                {
                    adapter.update(it)
                })
    }
}