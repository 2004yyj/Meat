plugins {
    id ("java-library")
    id ("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    //coroutines
    implementation(Dependencies.Coroutines.core)

    //paging (테스트 전용, 안드로이드 의존성이 존재하지 않음)
    implementation (Dependencies.Androidx.pagingCommon)
    implementation (Dependencies.Androidx.pagingCommonKtx)
}