package jasmine

import java.text.SimpleDateFormat
import java.util.*

/**
 * <pre>
 *     author: xuxin
 *     time  : 2021/5/12
 *     desc  : 配置相关
 * </pre>
 */
object Deploy {
    const val kotlinVersion = "1.4.31"
    const val gradleVersion = "4.2.0"

    const val pluginAndroidId = "com.android.application"
    const val pluginAndroid = "android"
    const val pluginAndroidExtensions = "android.extensions"

    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 23
    const val targetSdkVersion = 30 //note:target 版本过高有待确定?

    const val jasmineVersionCode = 1
    const val jasmineVersionName = "1.0"
}