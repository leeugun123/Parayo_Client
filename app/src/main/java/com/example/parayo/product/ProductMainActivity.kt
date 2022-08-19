package com.example.parayo.product

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.parayo.R
import com.example.parayo.product.list.ProductListPageradapter
import net.codephobia.ankomvvm.components.BaseActivity
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.support.v4.drawerLayout
import org.jetbrains.anko.toolbar
import kotlin.reflect.KClass

class ProductMainActivity : BaseActivity<ProductMainViewModel>(){

    override val viewModelType = ProductMainViewModel::class
    private val ui by lazy { ProductMainUI(getViewModel()) }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        ui.setContentView(this)

        ui.viewpager.adapter = ProductListPageradapter(supportFragmentManager)
        ui.tablayout.setupWithViewPager(ui.viewpager)


        setupDrawerListener()

    }

    private fun setupDrawerListener() {

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout(),
            //ui.toolBar
            R.string.open_drawer_description,
            R.string.close_drawer_descripton
        )

        drawerLayout().addDrawerListener(toggle)

        toggle.syncState()
    }


}