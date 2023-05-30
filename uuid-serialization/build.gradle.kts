
import pw.binom.publish.useDefault

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("maven-publish")
    if (pw.binom.Target.ANDROID_JVM_SUPPORT) {
        id("com.android.library")
    }
}

apply<pw.binom.KotlinConfigPlugin>()
kotlin {
    allTargets()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-common"))
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
        useDefault()
    }
}

tasks.withType<Test> {
    this.testLogging {
        this.showStandardStreams = true
    }
}
if (pw.binom.Target.ANDROID_JVM_SUPPORT) {
    apply<pw.binom.plugins.AndroidSupportPlugin>()
}
apply<pw.binom.plugins.ConfigPublishPlugin>()
