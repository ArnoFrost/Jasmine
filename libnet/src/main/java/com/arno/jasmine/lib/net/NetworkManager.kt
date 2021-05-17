package com.arno.jasmine.lib.net

import com.arno.jasmine.lib.common.util.JLog
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  : 网络层
 * </pre>
 */
class NetworkManager private constructor() : INetworkManager {

    lateinit var mOkHttpClient: OkHttpClient
    lateinit var mRetrofit: Retrofit

    companion object {
        private const val TAG = "JNetworkManager"
        val INSTANCE: NetworkManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkManager()
        }

        @JvmStatic
        fun getDefaultOkhttpBuilder(hasLog: Boolean, defaultTime: Long): OkHttpClient.Builder {
            var loggingInterceptor: HttpLoggingInterceptor? = null
            if (hasLog) {
                loggingInterceptor = HttpLoggingInterceptor { messages ->
                    JLog.d(TAG, "Message =$messages")
                }
            }

            return OkHttpClient.Builder().apply {
                loggingInterceptor?.let {
                    this.addInterceptor(it)
                }
                connectTimeout(defaultTime, TimeUnit.SECONDS)
            }
        }

        @JvmStatic
        fun getDefaultRetrofitBuilder(
            okHttpClient: OkHttpClient,
            baseUrl: String,
        ): Retrofit.Builder {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
        }

        @JvmStatic
        fun initNetwork(builder: Builder): NetworkManager {
            builder.build()
            return INSTANCE
        }

    }

    /**
     * 初始化项目
     * @param okHttpClient OkHttpClient
     * @param retrofit Retrofit
     */
    private fun setNetworkManger(okHttpClient: OkHttpClient, retrofit: Retrofit) {
        mOkHttpClient = okHttpClient
        mRetrofit = retrofit
    }

    class Builder {
        var mDefaultTime = 30L
        var mOkHttpClient: OkHttpClient? = null
        var mRetrofit: Retrofit? = null
        var mBaseUrl: String = ""

        fun okhttpClient(client: OkHttpClient): Builder {
            mOkHttpClient = client
            return this
        }

        fun retrofitClient(retrofit: Retrofit): Builder {
            mRetrofit = retrofit
            return this
        }

        fun setBaseUrl(baseUrl: String): Builder {
            mBaseUrl = baseUrl
            return this
        }

        fun setDefaultTime(defaultTime: Long): Builder {
            mDefaultTime = defaultTime
            return this
        }

        fun build(): NetworkManager {
            if (mOkHttpClient == null) {
                mOkHttpClient = getDefaultOkhttpBuilder(BuildConfig.DEBUG, mDefaultTime).build()
            }
            mOkHttpClient?.let { mOkClient ->
                if (mRetrofit == null) {
                    mRetrofit = getDefaultRetrofitBuilder(mOkClient, mBaseUrl).build()
                }
                mRetrofit?.let { mRetrofitClient ->
                    NetworkManager.INSTANCE.setNetworkManger(okHttpClient = mOkClient,
                        retrofit = mRetrofitClient)
                }
            }


            return NetworkManager()
        }
    }

    override fun release() {
    }

    override fun release(tag: String) {
    }
}