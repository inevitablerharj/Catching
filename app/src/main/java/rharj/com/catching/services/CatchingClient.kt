package rharj.com.catching.services

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import rharj.com.catching.utils.Utils

class CatchingClient(applicationContext: Context) : OkHttpClient() {

        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(applicationContext.cacheDir, cacheSize)

        val okHttpClient = OkHttpClient.Builder()
                .cache(myCache)
                .addInterceptor { chain ->
                    var request = chain.request()
                    request = if (Utils.hasNetwork(applicationContext)!!)
                        request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                    else
                        request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                    chain.proceed(request)
                }
                .build()

}