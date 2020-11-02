package com.example.demo

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mResponseTv: TextView? = null
    private var mAPIService: APIService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etname = findViewById<View>(R.id.et_title) as EditText
        val etsalary = findViewById<View>(R.id.et_body) as EditText
        val etage = findViewById<View>(R.id.et_age) as EditText
        val submitBtn = findViewById<View>(R.id.btn_submit) as Button

        mResponseTv = findViewById<View>(R.id.tv_response) as TextView

        mAPIService = ApiUtils.aPIService
        submitBtn.setOnClickListener {
            val title = etname.text.toString().trim { it <= ' ' }
            val body = etsalary.text.toString().trim { it <= ' ' }
            val age = etage.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body) && !TextUtils.isEmpty(age)) {
                sendPost(title, body, age)
            }
        }
    }

    fun sendPost(title: String?, body: String?, age: String?) {
        mAPIService!!.savePost(title, body, age).enqueue(object : Callback<Post?> {
            override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                if (response.isSuccessful) {
                    showResponse(response.body().toString())
                    Log.i(TAG, "post submitted to API." + response.body().toString())
                }
            }

            override fun onFailure(call: Call<Post?>?, t: Throwable?) {
                Log.e(TAG, "Unable to submit post to API.")
            }
        })
    }

    fun showResponse(response: String?) {
        if (mResponseTv!!.visibility == View.GONE) {
            mResponseTv!!.visibility = View.VISIBLE
        }
        mResponseTv!!.text = response
    }

    companion object {
        private const val TAG = ""
    }
}