package com.pmacademy.catsapp.cats.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.pmacademy.catsapp.*
import com.pmacademy.catsapp.cats.data.Cat
import com.pmacademy.catsapp.databinding.CatsFragmentBinding
import javax.inject.Inject

class CatsFragment: Fragment(R.layout.cats_fragment) {

    companion object {
        private const val ITEMS_COUNT_IN_RAW = 3
        fun newInstance() = CatsFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: CatsFragmentBinding
    private lateinit var viewModel: CatsViewModel
    private val catsAdapter = CatsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CatsFragmentBinding.bind(view)
        setupViewModel()
        setupCatsRecyclerView()
        observeCats()
        viewModel.loadMoreCats()
    }

    private fun setupViewModel() {
        (requireActivity() as MainActivity).daggerComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CatsViewModel::class.java)
    }

    private fun setupCatsRecyclerView() {
        with(binding.rvCats) {
            layoutManager = GridLayoutManager(context, ITEMS_COUNT_IN_RAW)
            adapter = catsAdapter
            LinearUIPagination(this, viewModel::loadMoreCats)
        }
    }

    private fun observeCats() {
        viewModel.catsLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is CatsState.Loading -> showLoading()
                is CatsState.Content -> showContent(it.cats)
            }
        }
    }

    private fun showContent(cats: List<Cat>) {
        with(binding) {
            rvCats.show()
            pbLoading.hide()
        }
        catsAdapter.submitList(cats)
    }

    private fun showLoading() {
        with(binding) {
            pbLoading.show()
            rvCats.hide()
        }
    }
}
