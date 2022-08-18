package com.example.parayo.product

import android.app.Application
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import com.example.parayo.product.category.categoryList
import com.example.parayo.product.registration.ProductRegistrationActivity
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class ProductMainViewModel (app : Application) : BaseViewModel(app){


    fun openRegistrationActivity(){

        startActivity<ProductRegistrationActivity>{
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        }

    }


}


