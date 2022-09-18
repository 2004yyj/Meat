object Dependencies {
    object Version {
        const val roomPaging = "2.5.0-alpha03"
        const val androidTest = "1.4.0"
        const val room = "2.5.0-alpha03"
        const val paging = "3.1.1"
        const val pagingCompose = "1.0.0-alpha16"
        const val coil = "2.2.1"
        const val pager = "0.26.3-beta"
        const val hiltViewModel = "1.0.0"
        const val mockWebServer = "4.10.0"
        const val hilt = "2.43.2"
        const val core = "1.7.0"
        const val compose = "1.2.1"
        const val lifecycle = "2.5.1"
        const val coroutines = "1.6.4"
        const val composeActivity = "1.5.0"
        const val junit = "4.13.2"
        const val androidJunit = "1.1.3"
        const val espresso = "3.4.0"
        const val navigation = "2.5.2"
        const val retrofit = "2.9.0"
    }

    object Androidx {
        const val navigation = "androidx.navigation:navigation-compose:${Version.navigation}"
        const val core = "androidx.core:core-ktx:${Version.core}"
        const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
        const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}"
        const val pagingCompose = "androidx.paging:paging-compose:${Version.pagingCompose}"
        const val pagingCommon = "androidx.paging:paging-common:${Version.paging}"
        const val pagingCommonKtx = "androidx.paging:paging-common-ktx:${Version.paging}"
        const val pagingRuntime = "androidx.paging:paging-runtime:${Version.paging}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
        const val mockWebServer =  "com.squareup.okhttp3:mockwebserver:${Version.mockWebServer}"
    }

    object Database {
        const val room = "androidx.room:room-runtime:${Version.room}"
        const val roomKtx = "androidx.room:room-ktx:${Version.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Version.room}"
        const val roomTest = "androidx.room:room-testing:${Version.room}"
        const val roomPaging = "androidx.room:room-paging:${Version.roomPaging}"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"
    }

    object Test {
        const val junit = "junit:junit:${Version.junit}"
        const val androidTestCore = "androidx.test:core:${Version.androidTest}"
        const val androidTestRules = "androidx.test:rules:${Version.androidTest}"
        const val androidJunit = "androidx.test.ext:junit:${Version.androidJunit}"
    }

    object Project {
        const val data = ":data"
        const val domain = ":domain"
        const val presentation = ":presentation"
    }

    object DaggerHilt {
        const val compiler = "com.google.dagger:hilt-compiler:${Version.hilt}"
        const val android = "com.google.dagger:hilt-android:${Version.hilt}"
        const val hiltViewModel = "androidx.hilt:hilt-navigation-compose:${Version.hiltViewModel}"
    }

    object Accompanist {
        const val pager = "com.google.accompanist:accompanist-pager:${Version.pager}"
        const val pagerIndicator = "com.google.accompanist:accompanist-pager-indicators:${Version.pager}"
    }

    object Image {
        const val coil = "io.coil-kt:coil-compose:${Version.coil}"
    }
}