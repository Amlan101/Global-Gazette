package com.example.globalgazette.repository

import com.example.globalgazette.api.RetrofitInstance
import com.example.globalgazette.database.ArticleDAO
import com.example.globalgazette.models.Article

class NewsRepository(private val articleDAO: ArticleDAO) {

    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getHeadlines(countryCode, pageNumber)

    suspend fun searchForNews(query: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(query, pageNumber)

    suspend fun insert(article: Article) =
        articleDAO.insert(article)

    suspend fun delete(article: Article) =
        articleDAO.delete(article)

    fun getFavouriteNews() = articleDAO.getAllArticles()
}