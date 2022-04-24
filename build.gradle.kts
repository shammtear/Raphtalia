plugins {
    kotlin("jvm") version libs.versions.kotlin apply false
}

subprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions.jvmTarget = "17"

            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf("-opt-in=kotlin.RequiresOptIn")
            }
        }
    }
}