package jasmine

/**
 * <pre>
 *     author: Arno
 *     time  : 2021/5/12
 *     desc  : 库相关配置
 * </pre>
 */
object Library {
    // CORE
    private const val COROUTINES_VERSION = "1.4.3"
    const val KOTLIN_LIB =
        "org.jetbrains.kotlin:kotlin-stdlib:${Deploy.kotlinVersion}"
    const val KOTLINX_COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"

    //AndroidX
    const val ANDROIDX_ACTIVITY = "androidx.activity:activity-ktx:1.2.3"
    const val ANDROIDX_ANNOTATION = "androidx.annotation:annotation:1.2.0"
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:1.2.0"
    const val ANDROIDX_APPCOMPAT_RESOURCES = "androidx.appcompat:appcompat-resources:1.2.0"
    const val ANDROIDX_COLLECTION = "androidx.collection:collection-ktx:1.1.0"
    const val ANDROIDX_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val ANDROIDX_CORE = "androidx.core:core-ktx:1.3.2"
    const val ANDROIDX_FRAGMENT = "androidx.fragment:fragment-ktx:1.3.3"
    const val ANDROIDX_MULTIDEX = "androidx.multidex:multidex:2.0.1"
    const val ANDROIDX_PAGING3 = "androidx.paging:paging-runtime:3.0.0"
    const val ANDROIDX_RECYCLER_VIEW = "androidx.recyclerview:recyclerview:1.2.0"

    private const val LIFECYCLE_VERSION = "2.3.1"
    const val ANDROIDX_LIFECYCLE_COMMON =
        "androidx.lifecycle:lifecycle-common-java8:$LIFECYCLE_VERSION"
    const val ANDROIDX_LIFECYCLE_LIVEDATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"
    const val ANDROIDX_LIFECYCLE_VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"

    const val MATERIAL = "com.google.android.material:material:1.3.0"

    //Hilt
    //classpath "com.google.dagger:hilt-android-gradle-plugin:$versions.daggerHilt"
    private const val HILT_VERSION = "2.35.1"
    const val ANDROIDX_HILT =
        "com.google.dagger:hilt-android:$HILT_VERSION"
    const val ANDROIDX_HILT_COMPILER =
        "com.google.dagger:hilt-android-compiler:$HILT_VERSION"

    //Net
    private const val OKHTTP = "4.9.1"
    const val NET_OKHTTP = "com.squareup.okhttp3:okhttp:$OKHTTP"
    const val NET_OKHTTP_LOG = "com.squareup.okhttp3:logging-interceptor:3.5.0"

    private const val RETROFIT = "2.9.0"
    const val NET_RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT"
    const val NET_RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:$RETROFIT"

    //Util
    private const val BLANKJ = "1.30.6"
    const val UTIL_BLANKJ = "com.blankj:utilcodex:$BLANKJ"

    // TEST
    const val JUNIT = "junit:junit:4.13.2"
    const val KOTLINX_COROUTINES_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:$COROUTINES_VERSION"

    const val ANDROIDX_TEST_CORE = "androidx.test:core-ktx:1.3.0"
    const val ANDROIDX_TEST_JUNIT = "androidx.test.ext:junit-ktx:1.1.2"
    const val ANDROIDX_TEST_RULES = "androidx.test:rules:1.3.0"
    const val ANDROIDX_TEST_RUNNER = "androidx.test:runner:1.3.0"
}