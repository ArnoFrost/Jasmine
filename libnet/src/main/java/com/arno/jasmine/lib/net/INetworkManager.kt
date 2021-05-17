package com.arno.jasmine.lib.net

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/17
 *     desc  :
 * </pre>
 */
interface INetworkManager {
    fun release()
    fun release(tag: String)
}