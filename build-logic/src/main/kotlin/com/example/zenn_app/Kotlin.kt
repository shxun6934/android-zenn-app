package com.example.zenn_app

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

object Kotlin {

    fun Project.setupKotlinOptions(
        extension: CommonExtension<*, *, *, *>,
    ) {
        extension.apply {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()

                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-opt-in=kotlin.RequiresOptIn"
                )
            }
        }
    }

    fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
        (this as ExtensionAware).extensions.configure("kotlinOptions", block)
    }
}
