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

            with(buildFeatures) {
                buildConfig = false
                aidl = false
                compose = false
                prefab = false
                renderScript = false
                resValues = false
                shaders = false
                viewBinding = false
            }
        }

        tasks.matching { it.name.startsWith("lint") }.configureEach { this.enabled = false }
    }
}
