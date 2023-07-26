import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.google.devtools.ksp").version("1.8.20-1.0.10")
}

group = "com.sandstonelauncher"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val koinVersion = "3.4.2"
val koinKspVersion = "1.2.2"

dependencies {
    ksp("io.insert-koin:koin-ksp-compiler:$koinKspVersion")
}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val jvmTest by getting

        val jvmMain by getting {
            kotlin.srcDirs("build/generated/ksp/jvm/jvmMain/kotlin")

            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("io.insert-koin:koin-core:$koinVersion")
                implementation("io.insert-koin:koin-annotations:$koinKspVersion")
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "app"
            packageVersion = "1.0.0"
        }
    }
}
