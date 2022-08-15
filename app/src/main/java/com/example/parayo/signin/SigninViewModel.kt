package com.example.parayo.signin

import android.app.Application
import androidx.lifecycle.MutableLiveData
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class SigninViewModel(app : Application) : BaseViewModel(app) {

    val email = MutableLiveData("")
    val password = MutableLiveData("")
}