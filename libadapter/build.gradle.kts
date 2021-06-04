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
        versionCode = jasmine.Deploy.jasmineCommonVersionCode
        versionName = jasmine.Deploy.jasmineCommonVersionName

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

    // KOTLIN
    implementation(jasmine.Library.KOTLIN_LIB)
    implementation(jasmine.Library.KOTLINX_COROUTINES_ANDROID)

    // Android
    implementation(jasmine.Library.ANDROIDX_ACTIVITY)
    implementation(jasmine.Library.ANDROIDX_APPCOMPAT)
    implementation(jasmine.Library.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(jasmine.Library.ANDROIDX_FRAGMENT)
    implementation(jasmine.Library.ANDROIDX_LIFECYCLE_COMMON)
    implementation(jasmine.Library.ANDROIDX_LIFECYCLE_LIVEDATA)
    implementation(jasmine.Library.ANDROIDX_LIFECYCLE_VIEW_MODEL)
    implementation(jasmine.Library.ANDROIDX_RECYCLER_VIEW)
}
