package com.example.retrofitlearning.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitlearning.R
import com.example.retrofitlearning.activities.DetailActivity
import com.example.retrofitlearning.databinding.AdapterMainBinding
import com.example.retrofitlearning.models.Article
import com.example.retrofitlearning.models.PostResponseItem
import com.squareup.picasso.Picasso

class MainAdapter(var mContext: Context) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    var mList: ArrayList<Article> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MyViewHolder {

        var view = LayoutInflater.from(mContext).inflate(R.layout.adapter_main, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.MyViewHolder, position: Int) {
        var post = mList[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(list: ArrayList<Article>) {

        mList = list
        notifyDataSetChanged()
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var binding: AdapterMainBinding

        fun bind(article: Article) {

            binding = AdapterMainBinding.bind(itemView)
            binding.textViewTitle.text = article.title
            //binding.textViewDescription.text = article.description

            Picasso.get()
                .load("${article.urlToImage}")
                .into(binding.imageViewArticle)

            itemView.setOnClickListener {
                var intent = Intent(mContext, DetailActivity::class.java)
                intent.putExtra("image", article.urlToImage)
                intent.putExtra("title", article.title)
                intent.putExtra("author", article.author)
                intent.putExtra("date", article.publishedAt)
                intent.putExtra("body", article.description)
                mContext.startActivity(intent)
            }
        }

    }
}
