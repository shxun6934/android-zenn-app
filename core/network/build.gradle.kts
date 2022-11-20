plugins {
    id("zenn_app.android.library")
    id("zenn_app.android.library.kotlin")
    id("zenn_app.android.hilt")
    id("kotlinx-serialization")
}

android.namespace = "com.example.zenn_app.core.network"

dependencies {
    implementation(project(":core:model"))

    implementation(libs.androidxCoreKtx)

    implementation(libs.kotlinxDatetime)
    implementation(libs.kotlinxCoroutinesAndroid)
    implementation(libs.kotlinxSerialization)

    implementation(libs.okhttp)
    implementation(libs.okhttpLogging)
    implementation(libs.retrofit)
    implementation(libs.retrofitKotlinxSerialization)
}
