plugins {
    id ("kotlin-kapt")
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
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
}

dependencies {
    implementation(project(Dependencies.Project.domain))
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.androidJunit)

    //retrofit
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.gsonConverter)
    implementation(Dependencies.Network.mockWebServer)

    //room
    implementation(Dependencies.Database.room)
    implementation(Dependencies.Database.roomKtx)
    kapt(Dependencies.Database.roomCompiler)
    implementation(Dependencies.Database.roomPaging)
    testImplementation(Dependencies.Database.roomTest)

    //coroutines
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.test)

    //hilt
    implementation(Dependencies.DaggerHilt.compiler)
}