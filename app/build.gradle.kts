plugins {
    id("zenn_app.android.application")
    id("zenn_app.android.application.kotlin")
    id("zenn_app.android.application.compose")
    id("zenn_app.android.hilt")
}

android {
    namespace = "com.example.zenn_app"

    defaultConfig {
        applicationId = "com.example.zenn_app"

        versionCode = 1
        versionName = "1.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))
    implementation(project(":core:ui"))

    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxActivityCompose)
    implementation(libs.androidxComposeUi)
    implementation(libs.androidxComposeUiToolingPreview)
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.androidxCoreSplashscreen)
    implementation(libs.androidxNavigationCompose)

    debugImplementation(libs.androidxComposeUiTooling)
}
