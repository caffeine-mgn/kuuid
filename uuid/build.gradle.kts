import org.jetbrains.kotlin.konan.target.HostManager
import pw.binom.publish.allTargets
import pw.binom.publish.applyDefaultHierarchyBinomTemplate

plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

apply<pw.binom.KotlinConfigPlugin>()
if (pw.binom.Target2.ANDROID_JVM_SUPPORT) {
    apply<pw.binom.plugins.AndroidSupportPlugin>()
}
kotlin {
    allTargets{
        -"wasmJs"
    }
    wasmJs()
    applyDefaultHierarchyBinomTemplate()
    sourceSets {
        commonTest.dependencies {
            api(kotlin("test"))
            api(kotlin("test-common"))
            api(kotlin("test-annotations-common"))
        }
    }
}

tasks.withType<Test> {
    this.testLogging {
        this.showStandardStreams = true
    }
}
apply<pw.binom.plugins.ConfigPublishPlugin>()
