plugins {
    id("zenn_app.android.library")
    id("zenn_app.android.library.kotlin")
    id("zenn_app.android.library.compose")
}

android.namespace = "com.example.zenn_app.core.designsystem"

dependencies {
    implementation(libs.androidxCoreKtx)

    implementation(libs.androidxComposeFoundation)
    implementation(libs.androidxComposeMaterialIconsExtended)
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.androidxComposeRuntime)
    implementation(libs.androidxComposeUi)
    implementation(libs.androidxComposeUiToolingPreview)
    implementation(libs.androidxComposeUiUtil)

    debugImplementation(libs.androidxComposeUiTooling)
}
