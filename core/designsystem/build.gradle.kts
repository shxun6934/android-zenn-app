plugins {
    id("zenn_app.android.library")
    id("zenn_app.android.library.kotlin")
    id("zenn_app.android.library.compose")
}

android.namespace = "com.example.zenn_app.core.designsystem"

dependencies {
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxComposeMaterialIconsExtended)
    implementation(libs.androidxComposeUi)
    implementation(libs.androidxComposeUiToolingPreview)
    implementation(libs.androidxComposeUiUtil)
    implementation(libs.androidxComposeMaterial3)

    debugImplementation(libs.androidxComposeUiTooling)
}
