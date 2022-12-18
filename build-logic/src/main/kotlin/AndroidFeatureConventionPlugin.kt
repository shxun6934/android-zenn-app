import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("zenn_app.android.library")
                apply("zenn_app.android.library.kotlin")
                apply("zenn_app.android.library.compose")
                apply("zenn_app.android.hilt")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:domain"))
                add("implementation", project(":core:model"))
                add("implementation", project(":core:ui"))

                add("implementation", libs.findLibrary("androidxCoreKtx").get())

                add("implementation", libs.findLibrary("androidxComposeFoundation").get())
                add("implementation", libs.findLibrary("androidxComposeFoundationLayout").get())
                add(
                    "implementation",
                    libs.findLibrary("androidxComposeMaterialIconsExtended").get()
                )
                add("implementation", libs.findLibrary("androidxComposeMaterial3").get())
                add("implementation", libs.findLibrary("androidxComposeRuntime").get())
                add("implementation", libs.findLibrary("androidxComposeUi").get())
                add("implementation", libs.findLibrary("androidxComposeUiToolingPreview").get())
                add("implementation", libs.findLibrary("androidxComposeUiUtil").get())

                add("implementation", libs.findLibrary("androidxLifecycleRuntimeKtx").get())
                add("implementation", libs.findLibrary("androidxLifecycleViewModelCompose").get())

                add("implementation", libs.findLibrary("accompanistFlowlayout").get())
                add("implementation", libs.findLibrary("accompanistWebview").get())

                add("implementation", libs.findLibrary("androidxHiltNavigationCompose").get())

                add("implementation", libs.findLibrary("coilKt").get())
                add("implementation", libs.findLibrary("coilKtCompose").get())

                add("implementation", libs.findLibrary("kotlinxDatetime").get())
                add("implementation", libs.findLibrary("kotlinxCoroutinesAndroid").get())

                add("debugImplementation", libs.findLibrary("androidxComposeUiTooling").get())
            }
        }
    }
}
