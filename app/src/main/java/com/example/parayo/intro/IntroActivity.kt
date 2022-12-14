package com.example.parayo.intro

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil.setContentView
import com.example.parayo.api.ParayoApi
import com.example.parayo.common.Prefs
import com.example.parayo.product.ProductMainActivity
import com.example.parayo.signin.SigninActivity
import com.example.parayo.signup.SignupActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import java.lang.Exception

class IntroActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        IntroActivityUI().setContentView(this)

        GlobalScope.launch {
            delay(1500)

            if(Prefs.token.isNullOrEmpty()){
                startActivity<SigninActivity>()
            }
            else
                startActivity<ProductMainActivity>()

            finish()
        }


    }



}