package com.example.parayo.intro

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import com.example.parayo.R
import org.jetbrains.anko.*

class IntroActivityUI : AnkoComponent<IntroActivity> {

    override fun createView(ui: AnkoContext<IntroActivity>): View {


        return ui.relativeLayout{
            gravity = Gravity.CENTER

            //PARAYO라는 텍스트 출력

            textView("PARAYO"){
                textSize = 24f
                textColorResource = com.google.android.material.R.color.design_dark_default_color_primary
                typeface = Typeface.DEFAULT_BOLD
            }


        }
    }


}