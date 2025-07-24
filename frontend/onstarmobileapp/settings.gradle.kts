pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // ✅ jitpack
        maven { url = uri("https://jitpack.io") }

        // ✅ naver map sdk 저장소
        maven { url = uri("https://repository.map.naver.com/archive/maven") }
    }
}

rootProject.name = "onstar-mobile-app"
include(":app")
 