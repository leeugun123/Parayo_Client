package com.example.parayo.product

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.parayo.product.category.categoryList
import net.codephobia.ankomvvm.lifecycle.BaseViewModel

class ProductMainViewModel (app : Application) : BaseViewModel(app){

    val imageUrls : List<MutableLiveData<String?>> = listOf(
        MutableLiveData(null as String?),
        MutableLiveData(null as String?),
        MutableLiveData(null as String?),
        MutableLiveData(null as String?)
    )

    val imageIds : MutableList<Long?> =
        mutableListOf(null,null,null,null)

    val productName = MutableLiveData("")
    val description = MutableLiveData("")
    val price = MutableLiveData("")
    val categories = MutableLiveData(categoryList.map{it.name})
    var categoryIdSelected: Int? = categoryList[0].id

    val descriptionLimit = 500
    val productNameLimit = 40

    val productNameLength = MutableLiveData("0/$productNameLimit")
    val descriptionLength = MutableLiveData("0/$descriptionLimit")

    fun checkProductNameLength(){

        productName.value?.let{
            if(it.length > productNameLimit){
                productName.value = it.take(productNameLimit)
            }
            productNameLength.value = "${productName.value?.length}/$productNameLimit"
        }
    }

    fun checkDescriptionLength(){

        description.value?.let {

            if(it.length > descriptionLimit){
                description.value = it.take(descriptionLimit)
            }

            descriptionLength.value =
                "${description.value?.length}/$descriptionLimit"
        }

    }

    fun onCategorySelect(position : Int){
        categoryIdSelected = categoryList[position].id
    }


}


