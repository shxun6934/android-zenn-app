// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    // Android
    alias(libs.plugins.androidGradlePlugin) apply false
    alias(libs.plugins.androidGradleLibraryPlugin) apply false

    // Kotlin
    alias(libs.plugins.kotlinPlugin) apply false
    alias(libs.plugins.kotlinJvmPlugin) apply false
    alias(libs.plugins.kotlinSerializationPlugin) apply false

    // DI
    alias(libs.plugins.hiltPlugin) apply false
}
