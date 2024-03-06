package com.shahad.ecommerce_app.utils

import android.util.Log

fun Any?.dLog(tag: String = "ECOMMERCE_APP", message: String = "") {
    Log.d(tag, message +" "+ this.toString())
}

fun Any?.iLog(tag: String = "ECOMMERCE_APP", message: String = "") {
    Log.i(tag, message +" "+ this.toString())
}