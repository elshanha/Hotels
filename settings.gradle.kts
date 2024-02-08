pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Hotels"
include(":app")
include(":network")
include(":data")
include(":entities")
include(":domain")
include(":features")
include(":common")
include(":features:hotels")
