import com.android.build.gradle.LibraryExtension
import com.example.zenn_app.Android.setupAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                setupAndroid(this)
                defaultConfig.targetSdk = 33
            }
        }
    }
}
