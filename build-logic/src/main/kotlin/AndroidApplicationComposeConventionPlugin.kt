import com.android.build.api.dsl.ApplicationExtension
import com.example.zenn_app.Compose.setupCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            extensions.configure<ApplicationExtension> {
                setupCompose(this)
            }
        }
    }
}
