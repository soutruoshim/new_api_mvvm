package com.srhdp.newapimvvm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.srhdp.newapimvvm.databinding.FragmentInfoBinding
import com.srhdp.newapimvvm.presentation.viewmodel.NewsViewModel

class InfoFragment : Fragment() {
    private lateinit var fragmentInfoBinding: FragmentInfoBinding
    private lateinit var viewModel : NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        val args : InfoFragmentArgs by navArgs()
        val article = args.selectedArticle
        Log.i("MYTAG",article.url)



        fragmentInfoBinding.wvInfo.apply {
            webViewClient = WebViewClient()
            if(article.url!=null) {
                loadUrl(article.url)
            }
        }
    }
}