plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.room)
}

android {
    namespace = "com.hmtest.androidnewsetup"
    compileSdk {
        version = release(libs.versions.compile.sdk.version.get().toInt())
    }

    defaultConfig {
        applicationId = "com.hmtest.androidnewsetup"
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    //noinspection WrongGradleMethod
    room {
        schemaDirectory("$projectDir/schemas")
        generateKotlin = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Hilt
    ksp(libs.dagger.hilt.android.compiler)
    implementation(libs.dagger.hilt.android)

    // Room DB
    ksp(libs.room.compiler)
    implementation(libs.bundles.room)

    // Unit testing
    testImplementation(libs.junit)

    // Instrumentation testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
}
