package kr.hs.b1nd.intern.mentomen.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.hs.b1nd.intern.mentomen.R

class AddFragment : Fragment(),AddViewModel.AddCallBack {

    private lateinit var binding: FragmentAddBinding
    private lateinit var addViewModel: AddViewModel

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    private fun initRecyclerView() {
        categoryAdapter = CategoryAdapter(requireContext()) {
            setList(it)
        }
        binding.rvKategorie.adapter = categoryAdapter
        categoryAdapter.submitList(
            listOf(
                CategoryItem("Android", false),
                CategoryItem("iOS", false),
                CategoryItem("Web", false),
                CategoryItem("Server", false),
                CategoryItem("Design", false)
            )
        )
    }

    private fun setList(name: String) {
        categoryAdapter.submitList(
            listOf(
                CategoryItem("Android", name.equals("Android")),
                CategoryItem("iOS", name.equals("iOS")),
                CategoryItem("Web", name.equals("Web")),
                CategoryItem("Server", name.equals("Server")),
                CategoryItem("Design", name.equals("Design"))
            )
        )
    }

    private fun performViewModel() {
        addViewModel = ViewModelProvider(this)[AddViewModel::class.java]
        binding.vm = addViewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }
    private fun startDefaultGalleryApp() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, 2000)
    }

    override fun onClickImage() {
        startDefaultGalleryApp()
    }

}