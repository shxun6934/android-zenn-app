package com.example.zenn_app

import com.android.build.api.dsl.CommonExtension
import com.example.zenn_app.Kotlin.kotlinOptions
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import java.io.File

object Compose {
    fun Project.setupCompose(
        extension: CommonExtension<*, *, *, *>,
    ) {
        extension.apply {
            buildFeatures.compose = true

            composeOptions {
                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
                kotlinCompilerExtensionVersion =
                    libs.findVersion("androidxCompose").get().toString()
            }

            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + buildComposeMetricsParameters()
            }
        }
    }

    private fun Project.buildComposeMetricsParameters(): List<String> {
        val metricParameters = mutableListOf<String>()
        val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
        val enableMetrics = (enableMetricsProvider.orNull == "true")
        if (enableMetrics) {
            val metricsFolder = File(project.buildDir, "compose-metrics")
            metricParameters.add("-P")
            metricParameters.add(
                "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" + metricsFolder.absolutePath
            )
        }

        val enableReportsProvider = project.providers.gradleProperty("enableComposeCompilerReports")
        val enableReports = (enableReportsProvider.orNull == "true")
        if (enableReports) {
            val reportsFolder = File(project.buildDir, "compose-reports")
            metricParameters.add("-P")
            metricParameters.add(
                "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" + reportsFolder.absolutePath
            )
        }
        return metricParameters.toList()
    }
}
