package com.example.zenn_app

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

object Android {

    fun Project.setupAndroid(
        extension: CommonExtension<*, *, *, *>,
    ) {
        extension.apply {
            compileSdk = 33

            defaultConfig {
                minSdk = 24
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
                isCoreLibraryDesugaringEnabled = true
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("coreLibraryDesugaring", libs.findLibrary("androidDesugarJdkLibs").get())
            }
        }
    }
}
