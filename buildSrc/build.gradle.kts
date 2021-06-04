plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://maven.aliyun.com/repository/public")
}

apply(from = "plugins.gradle.kts")

dependencies {
    implementation(rootProject.extra["androidPlugin"].toString())
    implementation(rootProject.extra["kotlinPlugin"].toString())
}
