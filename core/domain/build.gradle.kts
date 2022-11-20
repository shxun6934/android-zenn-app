plugins {
    id("zenn_app.android.library")
    id("zenn_app.android.library.kotlin")
    id("zenn_app.android.hilt")
}

android.namespace = "com.example.zenn_app.core.domain"

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    implementation(libs.kotlinxDatetime)
    implementation(libs.kotlinxCoroutinesAndroid)
}
