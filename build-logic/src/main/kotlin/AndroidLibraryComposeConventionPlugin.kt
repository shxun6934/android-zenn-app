import com.android.build.api.dsl.LibraryExtension
import com.example.zenn_app.Compose.setupCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                setupCompose(this)
            }
        }
    }
}
