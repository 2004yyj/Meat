plugins {
    id ("kotlin-kapt")
    id ("kotlin-android")
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {
    implementation(project(Dependencies.Project.data))
    implementation(project(Dependencies.Project.domain))

    implementation(Dependencies.Androidx.core)
    implementation(Dependencies.Androidx.composeUi)
    implementation(Dependencies.Androidx.composeMaterial)
    implementation (Dependencies.Androidx.composeActivity)
    implementation(Dependencies.Androidx.composeUiToolingPreview)
    implementation(Dependencies.Androidx.lifecycle)
    implementation(Dependencies.Androidx.lifecycleViewModel)

    //navigation
    implementation(Dependencies.Androidx.navigation)

    //hilt
    implementation(Dependencies.DaggerHilt.android)
    kapt(Dependencies.DaggerHilt.compiler)
    implementation(Dependencies.DaggerHilt.hiltViewModel)

    //coroutines
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.test)

    //retrofit
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.gsonConverter)

    //accompanist
    implementation(Dependencies.Accompanist.pager)
    implementation(Dependencies.Accompanist.pagerIndicator)
    implementation(Dependencies.Accompanist.swipeRefresh)

    //paging
    implementation(Dependencies.Androidx.pagingCompose)

    //room
    implementation(Dependencies.Database.room)
    kapt(Dependencies.Database.roomCompiler)

    //coil
    implementation(Dependencies.Image.coil)
}