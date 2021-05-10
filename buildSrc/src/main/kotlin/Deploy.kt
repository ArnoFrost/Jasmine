import java.text.SimpleDateFormat
import java.util.*

object Deploy {
    const val kotlinVersion = "1.3.72"
    const val gradleVersion = "4.2.0"

    const val pluginAndroidId = "com.android.application"
    const val pluginAndroid = "android"
    const val pluginAndroidExtensions = "android.extensions"

    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 23

    //note:target 版本过高有待确定?
    const val targetSdkVersion = 30

    const val jasmineVersionCode = 1
    const val jasmineVersionName = "1.0"

    //依赖
    //xxx



    fun getSystemTime(): String {
        val mSimpleDateFormat =
            SimpleDateFormat("YYYY_MM_dd_HH_mm_ss", java.util.Locale.CHINA)
        return mSimpleDateFormat.format(java.lang.System.currentTimeMillis())
    }
}