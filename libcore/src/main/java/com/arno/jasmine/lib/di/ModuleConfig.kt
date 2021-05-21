package com.arno.jasmine.lib.di

import com.arno.jasmine.lib.config.JAppliesOptions
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/20
 *     desc  : 配置依赖注入能力
 * </pre>
 */
class ModuleConfig {

    class Builder {
        internal var baseUrl: HttpUrl? = null
        internal var retrofitOptions: JAppliesOptions.RetrofitOptions? = null
        internal var okHttpClientOptions: JAppliesOptions.OkHttpClientOptions? = null
        internal var roomDatabaseOptions: JAppliesOptions.RoomDatabaseOptions? = null
        fun setBaseUrl(baseUrl: String?): Builder {
            baseUrl?.let {
                this.baseUrl = baseUrl.toHttpUrlOrNull()
            }
            return this
        }

        fun setBaseUrl(baseUrl: HttpUrl): Builder {
            this.baseUrl = baseUrl
            return this
        }

        fun setRetrofitOptions(retrofitOptions: JAppliesOptions.RetrofitOptions?): Builder {
            this.retrofitOptions = retrofitOptions
            return this
        }

        fun setOkHttpClientOptions(okHttpClientOptions: JAppliesOptions.OkHttpClientOptions?): Builder {
            this.okHttpClientOptions = okHttpClientOptions
            return this
        }

        fun setRoomDatabaseOptions(roomDatabaseOptions: JAppliesOptions.RoomDatabaseOptions?): Builder {
            this.roomDatabaseOptions = roomDatabaseOptions
            return this
        }
    }
}