package com.example.parayo.product

import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.design.navigationView
import org.jetbrains.anko.support.v4.drawerLayout

class ProductMainUI(private val viewModel: ProductMainViewModel) : AnkoComponent<ProductMainActivity> {

    override fun createView(ui: AnkoContext<ProductMainActivity>) =

        ui.drawerLayout {
            verticalLayout {
            }.lparams(matchParent, matchParent)


            navigationView {
            }.lparams(wrapContent, matchParent){
                gravity = Gravity.LEFT
            }


        }


}