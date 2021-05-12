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
        versionCode = jasmine.Deploy.jasmineVersionCode
        versionName = jasmine.Deploy.jasmineVersionName

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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(jasmine.Library.KOTLIN_LIB)
    implementation(jasmine.Library.KOTLINX_COROUTINES_ANDROID)


    implementation(jasmine.Library.ANDROIDX_CORE)
    implementation(jasmine.Library.ANDROIDX_APPCOMPAT)
    implementation(jasmine.Library.MATERIAL)
    implementation(jasmine.Library.ANDROIDX_CONSTRAINT_LAYOUT)

    //Test
    testImplementation(jasmine.Library.JUNIT)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_CORE)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_JUNIT)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_RULES)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_RUNNER)

}