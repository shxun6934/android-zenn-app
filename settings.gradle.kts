pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ZennApp"
include(":app")
val modules = listOf(
    "core-data",
    "core-designsystem",
    "core-domain",
    "core-model",
    "core-network",
    "core-ui",
    "feature-tech"
)
modules.forEach { filePath ->
    val (type, name) = filePath.split("-")
    val newProjectName = ":${type}:${name}"
    include(newProjectName)
}
