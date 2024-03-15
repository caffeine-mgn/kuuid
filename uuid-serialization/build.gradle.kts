
import org.jetbrains.kotlin.konan.target.HostManager
import pw.binom.publish.allTargets
import pw.binom.publish.applyDefaultHierarchyBinomTemplate

plugins {
    kotlin("multiplatform")
    id("maven-publish")
    id("kotlinx-serialization")
}

apply<pw.binom.KotlinConfigPlugin>()
if (pw.binom.Target2.ANDROID_JVM_SUPPORT) {
    apply<pw.binom.plugins.AndroidSupportPlugin>()
}
apply<pw.binom.plugins.ConfigPublishPlugin>()
kotlin {
    allTargets()
    applyDefaultHierarchyBinomTemplate()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":uuid"))
                api("org.jetbrains.kotlinx:kotlinx-serialization-core:${pw.binom.Versions.KOTLINX_SERIALIZATION_VERSION}")
            }
        }
        val commonTest by getting {
            dependencies {
                api(kotlin("test-common"))
                api(kotlin("test-annotations-common"))
            }
        }
    }
}

tasks.withType<Test> {
    this.testLogging {
        this.showStandardStreams = true
    }
}
