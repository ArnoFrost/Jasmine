plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(jasmine.Deploy.compileSdkVersion)
    buildToolsVersion(jasmine.Deploy.buildToolsVersion)

    defaultConfig {
        minSdkVersion(jasmine.Deploy.minSdkVersion)
        targetSdkVersion(jasmine.Deploy.targetSdkVersion)
        versionCode = jasmine.Deploy.jasmineCoreVersionCode
        versionName = jasmine.Deploy.jasmineCoreVersionName

        testInstrumentationRunner = jasmine.Deploy.androidJunit
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(mapOf("path" to ":libcommon")))

    //KOTLIN
    implementation(jasmine.Library.KOTLIN_LIB)
    implementation(jasmine.Library.KOTLINX_COROUTINES_ANDROID)

    //Android
    implementation(jasmine.Library.ANDROIDX_ACTIVITY)
    implementation(jasmine.Library.ANDROIDX_APPCOMPAT)
    implementation(jasmine.Library.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(jasmine.Library.ANDROIDX_FRAGMENT)
    implementation(jasmine.Library.ANDROIDX_LIFECYCLE_COMMON)
    implementation(jasmine.Library.ANDROIDX_LIFECYCLE_LIVEDATA)
    implementation(jasmine.Library.ANDROIDX_LIFECYCLE_VIEW_MODEL)

    //DI
    api(jasmine.Library.KOIN_CORE)
    api(jasmine.Library.KOIN_ANDROID)
    api(jasmine.Library.KOIN_ANDROID_EXT)


    //NET
    api(jasmine.Library.NET_OKHTTP)
    api(jasmine.Library.NET_OKHTTP_LOG)
    api(jasmine.Library.NET_RETROFIT)
    api(jasmine.Library.NET_RETROFIT_GSON)

    //DATA
    api(jasmine.Library.ANDROIDX_ROOM)
    kapt(jasmine.Library.ANDROIDX_ROOM_COMPILER)

    //LoadSir
    api(jasmine.Library.LOAD_SIR)

    //Test
    testImplementation(jasmine.Library.JUNIT)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_CORE)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_JUNIT)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_RULES)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_RUNNER)
}