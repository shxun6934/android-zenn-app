plugins {
    `kotlin-dsl`
}

group = "com.example.zenn_app.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.androidGradlePlugin)
    implementation(libs.kotlinGradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "zenn_app.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationKotlin") {
            id = "zenn_app.android.application.kotlin"
            implementationClass = "AndroidApplicationKotlinConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "zenn_app.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "zenn_app.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidLibrary") {
            id = "zenn_app.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryKotlin") {
            id = "zenn_app.android.library.kotlin"
            implementationClass = "AndroidLibraryKotlinConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "zenn_app.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "zenn_app.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}
