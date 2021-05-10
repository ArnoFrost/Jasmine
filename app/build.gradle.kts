plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        applicationId = "com.arno.jasmine"
        minSdkVersion(23)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

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
    val kotlin_version = "1.3.72"

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}