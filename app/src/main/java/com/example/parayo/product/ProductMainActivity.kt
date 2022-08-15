package com.example.parayo.product

import android.os.Bundle
import net.codephobia.ankomvvm.components.BaseActivity
import org.jetbrains.anko.setContentView
import kotlin.reflect.KClass

class ProductMainActivity : BaseActivity<ProductMainViewModel>(){

    override val viewModelType = ProductMainViewModel::class

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        ProductMainUI(getViewModel())
            .setContentView(this)

    }


}