plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}

android {
    compileSdkVersion(jasmine.Deploy.compileSdkVersion)
    buildToolsVersion(jasmine.Deploy.buildToolsVersion)

    defaultConfig {
        minSdkVersion(jasmine.Deploy.minSdkVersion)
        targetSdkVersion(jasmine.Deploy.targetSdkVersion)
        versionCode = jasmine.Deploy.jasmineAppVersionCode
        versionName = jasmine.Deploy.jasmineAppVersionName

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
    sourceSets {
        getByName("main") {
            res.srcDirs(listSubFile())
        }
    }
    android.applicationVariants.all {
        val buildType = this.buildType.name
        outputs.all {
            if (this is com.android.build.gradle.internal.api.ApkVariantOutputImpl) {
                when (buildType) {
                    "debug" -> {
                        this.outputFileName =
                            "Jasmine_DSL_v${defaultConfig.versionName}_${buildType}.apk"
                    }
                    "release" -> {
                        this.outputFileName =
                            "Jasmine_v${defaultConfig.versionName}_${buildType}.apk"
                    }
                    else -> {
                    }
                }
            }
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

//整理资源文件
fun listSubFile(): ArrayList<String> {
    val resFolder = "src/main/res/layouts"

    val files = file(resFolder).listFiles()
    val folders = ArrayList<String>()

    files?.let {
        it.forEach { file ->
            folders.add(file.absolutePath)
        }
    }

    folders.add(file(resFolder).parentFile.absolutePath)
    return folders
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(mapOf("path" to ":libcore")))
    implementation(project(mapOf("path" to ":libnet")))
    implementation(project(mapOf("path" to ":libcommon")))

    implementation(jasmine.Library.KOTLIN_LIB)
    implementation(jasmine.Library.KOTLINX_COROUTINES_ANDROID)


    implementation(jasmine.Library.ANDROIDX_CORE)
    implementation(jasmine.Library.ANDROIDX_APPCOMPAT)
    implementation(jasmine.Library.MATERIAL)
    implementation(jasmine.Library.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(jasmine.Library.ANDROIDX_PAGING3)
    implementation(jasmine.Library.ANDROIDX_ACTIVITY)
    implementation(jasmine.Library.ANDROIDX_FRAGMENT)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    //Test
    testImplementation(jasmine.Library.JUNIT)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_CORE)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_JUNIT)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_RULES)
    androidTestImplementation(jasmine.Library.ANDROIDX_TEST_RUNNER)
}