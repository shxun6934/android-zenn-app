import com.android.build.api.dsl.LibraryExtension
import com.example.zenn_app.Kotlin.setupKotlinOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryKotlinConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                setupKotlinOptions(this)
            }
        }
    }
}
