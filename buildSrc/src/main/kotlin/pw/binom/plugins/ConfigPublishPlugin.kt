package pw.binom.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigPublishPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply(pw.binom.publish.plugins.PrepareProject::class.java)
        target.extensions.getByType(pw.binom.publish.plugins.PublicationPomInfoExtension::class.java).apply {
            useApache2License()
            gitScm(PublishInfo.HTTP_PATH_TO_PROJECT)
            author(
                id = "subochev",
                name = "Anton Subochev",
                email = "caffeine.mgn@gmail.com",
            )
        }
    }
}
