package com.example.globalgazette.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.globalgazette.R
import com.example.globalgazette.databinding.FragmentArticleBinding
import com.example.globalgazette.presentation.NewsActivity
import com.example.globalgazette.presentation.viewmodels.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var binding: FragmentArticleBinding
    lateinit var newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        newsViewModel = (activity as NewsActivity).newsViewModel
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        binding.fab.setOnClickListener{
            newsViewModel.addToFavourites(article)
            Snackbar.make(view, "Added to Favourites", Snackbar.LENGTH_SHORT).show()
        }
    }
}