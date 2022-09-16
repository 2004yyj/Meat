object Dependencies {
    object Version {
        const val core = "1.7.0"
        const val compose = "1.2.1"
        const val lifecycle = "2.3.1"
        const val composeActivity = "1.3.1"
        const val junit = "4.13.2"
        const val androidJunit = "1.1.3"
        const val espresso = "3.4.0"
    }

    object Androidx {
        const val core = "androidx.core:core-ktx:${Version.core}"
        const val composeUi = "androidx.compose.ui:ui:${Version.compose}"
        const val composeMaterial = "androidx.compose.material:material:${Version.compose}"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
        const val composeActivity = "androidx.activity:activity-compose:${Version.composeActivity}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    }

    object Test {
        const val junit = "junit:junit:${Version.junit}"
        const val androidJunit = "androidx.test.ext:junit:${Version.androidJunit}"
        const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Version.compose}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
        const val composeUiTest = "androidx.compose.ui:ui-test-manifest:${Version.compose}"
    }

    object Project {
        const val data = ":data"
        const val domain = ":domain"
        const val presentation = ":presentation"
    }
}