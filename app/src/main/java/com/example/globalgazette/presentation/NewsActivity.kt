package com.example.globalgazette.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.globalgazette.R
import com.example.globalgazette.database.ArticleDatabase
import com.example.globalgazette.databinding.ActivityNewsBinding
import com.example.globalgazette.presentation.viewmodels.NewsViewModel
import com.example.globalgazette.presentation.viewmodels.NewsViewModelFactory
import com.example.globalgazette.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val articleDAO = ArticleDatabase.getDatabase(this).getArticleDao()
        val newsRepository = NewsRepository(articleDAO)
        val viewModelProviderFactory = NewsViewModelFactory(application, newsRepository)
        newsViewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController =  navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        // Hides the bottom nav bar when ArticleFragment is open
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.headlinesFragment, R.id.favouritesFragment, R.id.searchFragment ->
                    binding.bottomNavigationView.visibility = View.VISIBLE
                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }

    }
}