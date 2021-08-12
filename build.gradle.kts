plugins {
    kotlin("multiplatform") version "1.5.21" apply false
    id("com.android.library") apply false
}

subprojects {
    plugins.withId("com.android.library") {
        extensions.configure<com.android.build.gradle.BaseExtension> {
            compileSdkVersion(31)
            sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
            defaultConfig {
                minSdkVersion(21)
                targetSdkVersion(31)
            }
        }
    }
}
