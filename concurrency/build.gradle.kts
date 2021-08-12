plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()
    ios()
}

dependencies {
    commonMainImplementation(libs.coroutinesCore)
    commonMainImplementation(libs.ktorClientCore)
    commonMainImplementation(libs.mokoMvvmCore)
    commonMainImplementation(libs.mokoMvvmLiveData)
    commonMainImplementation(libs.mokoUtils)

    commonTestImplementation(libs.kotlinTestJUnit)
    commonTestImplementation(libs.ktorClientMock)
    commonTestImplementation(libs.mokoMvvmTest)
    commonTestImplementation(libs.mokoTestCore)
    commonTestImplementation(libs.mokoTestRobolectric)
}
