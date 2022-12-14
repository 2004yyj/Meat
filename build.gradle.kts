plugins {
    id ("com.android.application") version ("7.2.0") apply (false)
    id ("com.android.library") version ("7.2.0") apply (false)
    id ("org.jetbrains.kotlin.android") version ("1.7.10") apply (false)
    id ("org.jetbrains.kotlin.jvm") version ("1.7.10") apply (false)
    id ("com.google.dagger.hilt.android") version ("2.43.2") apply (false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}