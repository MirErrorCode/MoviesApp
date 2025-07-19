plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "mir.errorcode.moviesapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "mir.errorcode.moviesapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // Retrofit & Networking
    implementation(libs.retrofit)            // Retrofit for HTTP requests
    implementation(libs.converter.gson)      // Gson converter for Retrofit
    implementation(libs.okhttp)              // OkHttp HTTP client

    // Coroutines (Asynchronous programming)
    implementation(libs.kotlinx.coroutines.core)    // Core Coroutines library
    implementation(libs.kotlinx.coroutines.android) // Coroutines support for Android

    // Lifecycle & ViewModel (Architecture components)
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // ViewModel with Kotlin support
    implementation(libs.androidx.lifecycle.runtime.ktx)   // Lifecycle runtime components
    implementation(libs.androidx.lifecycle.livedata.ktx)  // LiveData with Kotlin extensions

    // Activity & Compose Runtime
    implementation(libs.androidx.activity.ktx)       // Activity KTX for easier APIs
    implementation(libs.androidx.runtime.livedata)    // Compose runtime LiveData integration

    // Dependency Injection (Hilt)
    implementation(libs.hilt.android)                 // Core Hilt library
    kapt(libs.hilt.compiler)                          // Hilt annotation processor (KAPT)
    implementation(libs.androidx.hilt.navigation.compose) // Hilt integration with Navigation Compose

    // Coil
    implementation(libs.coil.compose)



}