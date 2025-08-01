import pw.binom.publish.getExternalVersion

allprojects {
    version = getExternalVersion()
    group = "pw.binom"

    repositories {
        mavenLocal()
        mavenCentral()
        maven(url = "https://repo.binom.pw")
        maven(url = "https://plugins.gradle.org/m2/")
        maven(url = "https://maven.google.com")
    }
}

tasks {
    val publishToMavenLocal by creating {
        val self = this
        getTasksByName("publishToMavenLocal", true).forEach {
            if (it !== self) {
                dependsOn(it)
            }
        }
    }

    val publish by creating {
        val self = this
        getTasksByName("publish", true).forEach {
            if (it !== self) {
                dependsOn(it)
            }
        }
    }
}
