package com.example.retrofitlearning.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitlearning.R
import com.example.retrofitlearning.databinding.ActivityPostBinding
import com.example.retrofitlearning.models.PostGenerator
import com.example.retrofitlearning.models.PostResponse
import com.example.retrofitlearning.models.PostResponseItem
import com.example.retrofitlearning.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        init()
    }

    private fun init() {
       /* binding.buttonPost.setOnClickListener {
            var myid = binding.editTextUid.editableText.toString().toInt()
            var mytitle = binding.editTextTitle.editableText.toString()
            var mybody = binding.editTextBody.editableText.toString()
            var makepost = PostGenerator(mybody, mytitle, myid)

            var api = MyApi()
            api.makePost(makepost).enqueue(object : Callback<PostResponseItem> {
                override fun onResponse(
                    call: Call<PostResponseItem>,
                    response: Response<PostResponseItem>
                ) {
                    Toast.makeText(applicationContext, response.body()?.title + ", " + response.body()?.body, Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<PostResponseItem>, t: Throwable) {
                    Toast.makeText(applicationContext, "fail" + t.message, Toast.LENGTH_LONG).show()
                }

            })


        }*/
    }
}