package com.ankitdubey.randomuserkmmdemo.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ankitdubey.randomuserkmmdemo.Greeting
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.ankitdubey.randomuserkmmdemo.networking.RandomUserRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

        Greeting().greeting { randomUserDao, exception ->
            lifecycleScope.launch {
                if(randomUserDao!=null){
                    var name : String = ""
                    randomUserDao.results.firstOrNull()?.let {
                        name = "${it.name.first} ${it.name.last}"
                    }
                    tv.text = "Welcome $name"
                }
                else
                    tv.text = "Error ${exception.toString()}"
            }
        }

    }
}
