// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    apply(from = "buildSrc/plugins.gradle.kts")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(rootProject.extra["androidPlugin"].toString())
        classpath(rootProject.extra["kotlinPlugin"].toString())
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
        // classpath(rootProject.extra["ktlintPlugin"].toString())
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
    }
    // group = project.groupId
    // version = project.versionName
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}