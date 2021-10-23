package com.example.a25c992e3a3b6ce9eeb00901b1988403d

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.base.retrofit.RetrofitService
import com.example.a25c992e3a3b6ce9eeb00901b1988403d.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}