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
    packagingOptions {
        resources {
            excludes += "/META-INF/gradle/incremental.annotation.processors"
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
    androidTestImplementation(Dependencies.Test.androidTestCore)
    androidTestImplementation(Dependencies.Test.androidTestRules)

    //retrofit
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.gsonConverter)
    implementation(Dependencies.Network.mockWebServer)

    //room
    implementation(Dependencies.Database.room)
    implementation(Dependencies.Database.roomKtx)
    kapt(Dependencies.Database.roomCompiler)
    implementation(Dependencies.Database.roomPaging)
    androidTestImplementation(Dependencies.Database.roomTest)

    //coroutines
    implementation(Dependencies.Coroutines.core)
    implementation(Dependencies.Coroutines.test)

    //paging
    implementation (Dependencies.Androidx.pagingRuntime)
    testImplementation (Dependencies.Androidx.pagingRuntime)

    //hilt
    implementation(Dependencies.DaggerHilt.compiler)
}