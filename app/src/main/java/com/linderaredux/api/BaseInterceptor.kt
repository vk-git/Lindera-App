package com.linderaredux.api

import android.app.Application
import com.linderaredux.utils.Session
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class BaseInterceptor(internal var session: Session, internal var application: Application) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Accept", "application/json")
        /* if (session.getAccessToken() != null) {
             if (!session.getAccessToken().accessToken!!.isEmpty())
                 builder.addHeader(
                     "Authorization",
                     "${session.getAccessToken().tokenType} ${session.getAccessToken().accessToken}"
                 )
         }*/
        return chain.proceed(builder.build())
    }
}
