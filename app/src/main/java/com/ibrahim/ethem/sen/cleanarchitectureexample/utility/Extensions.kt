package com.ibrahim.ethem.sen.cleanarchitectureexample.utility

import android.view.View

fun View.setVisibility(isTrue : Boolean){
    visibility = if (isTrue){
        View.VISIBLE
    }else{
        View.GONE
    }
}