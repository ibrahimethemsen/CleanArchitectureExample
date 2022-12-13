package com.ibrahim.ethem.sen.cleanarchitectureexample.utility

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText

fun View.setVisibility(isTrue: Boolean) {
    visibility = if (isTrue) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

inline fun EditText.searchFilter(crossinline function: (String) -> Unit) {
    addTextChangedListener(
        object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                function(s.toString())
                println("text changed $s")
            }
        }
    )
}