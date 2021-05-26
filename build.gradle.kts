// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    apply(from = "buildSrc/plugins.gradle.kts")
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.aliyun.com/repository/public")
        gradlePluginPortal()
    }
    dependencies {
        classpath(rootProject.extra["androidPlugin"].toString())
        classpath(rootProject.extra["kotlinPlugin"].toString())
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        // classpath(rootProject.extra["koinPlugin"].toString())
        // classpath(rootProject.extra["hiltPlugin"].toString())
        // classpath(rootProject.extra["ktLintPlugin"].toString())
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        //TODO MavenPublish plugin?
        // classpath(rootProject.extra["mavenPublishPlugin"].toString())
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.aliyun.com/repository/public")
    }
    // group = project.groupId
    // version = project.versionName
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}