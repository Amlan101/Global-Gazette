package com.example.globalgazette.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.globalgazette.R
import com.example.globalgazette.models.Article

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val articleImage: ImageView = itemView.findViewById(R.id.articleImage)
        val articleSource: TextView = itemView.findViewById(R.id.articleSource)
        val articleTitle: TextView = itemView.findViewById(R.id.articleTitle)
        val articleDescription: TextView = itemView.findViewById(R.id.articleDescription)
        val articleDateTime: TextView = itemView.findViewById(R.id.articleDateTime)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
    }


    private val differCallBack = object: DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallBack)

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentArticle = differ.currentList[position]

        holder.itemView.apply {
            Glide.with(this)
                .load(currentArticle.urlToImage)
                .error(R.drawable.error_image_placeholder) // Add an error image
                .into(holder.articleImage)

            holder.articleSource.text = currentArticle.source?.name ?: "Unknown Source"
            holder.articleTitle.text = currentArticle.title ?: "No Title"
            holder.articleDescription.text = currentArticle.description ?: "No Description"
            holder.articleDateTime.text = currentArticle.publishedAt ?: "Unknown Date"

            setOnClickListener {
                onItemClickListener?.let {
                    it(currentArticle)
                }
            }
        }
    }

    fun setItemClickListener(listener: (Article) -> Unit){
        onItemClickListener = listener
    }
}