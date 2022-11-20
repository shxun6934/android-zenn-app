plugins {
    id("zenn_app.android.library")
    id("zenn_app.android.library.kotlin")
    id("zenn_app.android.library.compose")
}

android.namespace = "com.example.zenn_app.core.ui"

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:domain"))

    implementation(libs.androidxCoreKtx)

    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeFoundationLayout)
    implementation(libs.androidxComposeMaterialIconsExtended)
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.androidxComposeMaterial3WindowSizeClass)
    implementation(libs.androidxComposeRuntime)
    implementation(libs.androidxComposeUi)
    implementation(libs.androidxComposeUiToolingPreview)
    implementation(libs.androidxComposeUiUtil)

    implementation(libs.coilKt)
    implementation(libs.coilKtCompose)

    implementation(libs.kotlinxDatetime)

    debugImplementation(libs.androidxComposeUiTooling)
}
