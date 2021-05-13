package com.example.retrofitlearning.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitlearning.R
import com.example.retrofitlearning.adapters.MainAdapter
import com.example.retrofitlearning.databinding.ActivityMainBinding
import com.example.retrofitlearning.models.NewsResponse
import com.example.retrofitlearning.network.MyApi
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root


        setContentView(view)

        init()
    }

    @SuppressLint("CheckResult")
    private fun init() {




        val api = MyApi()
        api.getPost("us", "business", getString(R.string.myApi))
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(getObserver())

        mainAdapter = MainAdapter(this)



        binding.recyclerViewPosts.adapter = mainAdapter
        binding.recyclerViewPosts.layoutManager = LinearLayoutManager(this)


        /*binding.buttonMakePost.setOnClickListener {
            var intent= Intent(this, PostActivity::class.java)
            startActivity(intent)
        }*/


     /*       .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {

                    var myarray= ArrayList(response.body()?.articles!!)


                    mainAdapter.setData(myarray)
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "fail" + t.message, Toast.LENGTH_LONG).show()
                }

            })*/
    }



    private fun getObserver(): Observer<NewsResponse> {


        return object : Observer<NewsResponse> {
            override fun onSubscribe(d: Disposable) {
                Log.d("abc", "onSubscribe")


            }

            override fun onNext(t: NewsResponse) {
                Log.d("abc", "${t.toString()} + onNext")
                var myarray= ArrayList(t?.articles!!)


                mainAdapter.setData(myarray)

            }

            override fun onError(e: Throwable) {
                Log.d("abc", "onError")

            }

            override fun onComplete() {
                Log.d("abc", "onComplete")

            }

        }
    }
}