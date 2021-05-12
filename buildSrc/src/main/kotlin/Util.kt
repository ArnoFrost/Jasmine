package jasmine

import java.text.SimpleDateFormat
import java.util.*

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/12
 *     desc  : 工具类
 * </pre>
 */
object Util {

    //获取当前时间
    fun getSystemTime(): String {
        val mSimpleDateFormat =
            SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA)
        return mSimpleDateFormat.format(System.currentTimeMillis())
    }
}