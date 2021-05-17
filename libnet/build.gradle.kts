plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(jasmine.Deploy.compileSdkVersion)
    buildToolsVersion(jasmine.Deploy.buildToolsVersion)

    defaultConfig {
        minSdkVersion(jasmine.Deploy.minSdkVersion)
        targetSdkVersion(jasmine.Deploy.targetSdkVersion)
        versionCode = jasmine.Deploy.jasmineNetVersionCode
        versionName = jasmine.Deploy.jasmineNetVersionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(jasmine.Library.KOTLIN_LIB)
    implementation(jasmine.Library.KOTLINX_COROUTINES_ANDROID)

    //NET
    api(jasmine.Library.NET_OKHTTP)
    api(jasmine.Library.NET_OKHTTP_LOG)
    api(jasmine.Library.NET_RETROFIT)
    api(jasmine.Library.NET_RETROFIT_GSON)

    //Test
    testImplementation(jasmine.Library.JUNIT)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_CORE)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_JUNIT)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_RULES)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_RUNNER)

}