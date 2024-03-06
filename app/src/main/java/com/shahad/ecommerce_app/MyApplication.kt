package com.shahad.ecommerce_app

import android.annotation.SuppressLint
import android.app.Application
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.shahad.ecommerce_app.utils.dLog
import io.reactivex.schedulers.Schedulers

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        listingToInternetConnectivity()
    }

    @SuppressLint("CheckResult")
    private fun listingToInternetConnectivity() {
        ReactiveNetwork.observeInternetConnectivity().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io()).subscribe { isConnected: Boolean ->
                isConnected.dLog(TAG,"Connected to internet:")
                FirebaseCrashlytics.getInstance().setCustomKey("connected_to_internet", isConnected)
            }
    }
    companion object {
        private const val TAG = "MyApplication"
    }
}