package com.arno.jasmine.lib.util

import android.util.Log
import com.arno.jasmine.lib.core.BuildConfig

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/14
 *     desc  :
 * </pre>
 */
class JLog {


    companion object {
        val IS_DEBUG = BuildConfig.DEBUG
        fun d(tag: String, msg: String?) {
            if (IS_DEBUG) {
                Log.d(tag, msg ?: "")
            }
        }

        fun i(tag: String, msg: String?) {
            if (IS_DEBUG) {
                Log.i(tag, msg ?: "")
            }
        }

        fun e(tag: String, msg: String?) {
            if (IS_DEBUG) {
                Log.e(tag, msg ?: "")
            }
        }
    }

}