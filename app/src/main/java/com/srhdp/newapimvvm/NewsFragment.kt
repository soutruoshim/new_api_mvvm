package com.srhdp.newapimvvm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.srhdp.newapimvvm.databinding.FragmentNewsBinding
import com.srhdp.newapimvvm.presentation.adapter.NewsAdapter
import com.srhdp.newapimvvm.presentation.viewmodel.NewsViewModel

class NewsFragment : Fragment() {
    private  lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var fragmentNewsBinding: FragmentNewsBinding
    private var isLoading = false
    private var country = "us"
    private var page = 1
    private var isLastPage = false
    private var pages = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsBinding = FragmentNewsBinding.bind(view)
        viewModel= (activity as MainActivity).viewModel

        initRecyclerView()
        viewNewsList()
    }

    private fun initRecyclerView() {
        newsAdapter = NewsAdapter()
        fragmentNewsBinding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
    private fun showProgressBar(){
        isLoading = true
        fragmentNewsBinding.progressBar.visibility = View.VISIBLE
    }
    private fun hideProgressBar(){
        isLoading = false
        fragmentNewsBinding.progressBar.visibility = View.INVISIBLE
    }

    private fun viewNewsList() {
        viewModel.getNewsHeadLines(country,page)
        viewModel.newsHeadLines.observe(viewLifecycleOwner) { response ->
            when (response) {
                is com.srhdp.newapimvvm.data.util.Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {
                        Log.i("MYTAG", "came here ${it.articles.toList().size}")
                        newsAdapter.differ.submitList(it.articles.toList())
                        if (it.totalResults % 20 == 0) {
                            pages = it.totalResults / 20
                        } else {
                            pages = it.totalResults / 20 + 1
                        }
                        isLastPage = page == pages
                    }
                }
                is com.srhdp.newapimvvm.data.util.Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity, "An error occurred : $it", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                is com.srhdp.newapimvvm.data.util.Resource.Loading -> {
                    showProgressBar()
                }
            }
        }
    }

}