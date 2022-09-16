object Dependencies {
    object Version {
        const val core = "1.7.0"
        const val compose = "1.2.1"
        const val composeUi = "1.2.1"
        const val lifecycle = "2.5.1"
        const val composeActivity = "1.5.0"
        const val junit = "4.13.2"
        const val androidJunit = "1.1.3"
        const val espresso = "3.4.0"
        const val navigation = "2.5.2"
    }

    object Androidx {
        const val navigation = "androidx.navigation:navigation-compose:${Version.navigation}"
        const val core = "androidx.core:core-ktx:${Version.core}"
        const val composeUi = "androidx.compose.ui:ui:${Version.composeUi}"
        const val composeMaterial = "androidx.compose.material:material:${Version.composeUi}"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.composeUi}"
        const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}"
    }

    object Test {
        const val junit = "junit:junit:${Version.junit}"
        const val androidJunit = "androidx.test.ext:junit:${Version.androidJunit}"
        const val composeUiJunit = "androidx.compose.ui:ui-test-junit4:${Version.composeUi}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.composeUi}"
        const val composeUiTest = "androidx.compose.ui:ui-test-manifest:${Version.composeUi}"
    }

    object Project {
        const val data = ":data"
        const val domain = ":domain"
        const val presentation = ":presentation"
    }
}