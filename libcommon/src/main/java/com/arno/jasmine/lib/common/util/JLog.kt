package com.arno.jasmine.lib.common.util

import android.util.Log

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/14
 *     desc  : 日志辅助类
 * </pre>
 */
class JLog {
    companion object {
        val IS_DEBUG = true
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
