package com.ibrahim.ethem.sen.cleanarchitectureexample.utility

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onStart

fun View.setVisibility(isTrue: Boolean) {
    visibility = if (isTrue) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

 fun EditText.searchFilter() : Flow<String> {
       return callbackFlow {
           val textWatch =  object : TextWatcher {
               override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
               override fun afterTextChanged(s: Editable?) {}
               override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                   trySend(s.toString())
               }
           }
           addTextChangedListener(textWatch)
           awaitClose{
               removeTextChangedListener(textWatch)
           }
       }.onStart {
           text?.let {
               emit(it.toString())
           }
       }
}