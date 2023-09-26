import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import com.github.jk1.license.render.*

fun str(settingName: String): String {
    return project.property(settingName) as String
}

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.google.devtools.ksp").version("1.8.20-1.0.10")
    id("com.github.jk1.dependency-license-report").version("2.5")
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

licenseReport {
    outputDir = "$projectDir/licenses"
    configurations = arrayOf("runtimeClasspath")
    renderers = arrayOf(XmlReportRenderer("third-party-libs.xml", "Third Party Libraries"))

}

kotlin {
    jvm {
        jvmToolchain(11)
        withJava()
    }
    sourceSets {
        val jvmTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:1.9.0")
                implementation("junit:junit:4.13.2")
                implementation("org.junit.jupiter:junit-jupiter-api:5.10.0")

                // ** MOCKITO **
                implementation("org.mockito.kotlin:mockito-kotlin:5.0.0")
            }
        }

        val jvmMain by getting {
            kotlin.srcDirs("build/generated/ksp/jvm/jvmMain/kotlin")

            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("io.insert-koin:koin-core:$koinVersion")
                implementation("io.insert-koin:koin-annotations:$koinKspVersion")

                implementation("com.fasterxml.jackson.core:jackson-databind:2.0.1")
            }
        }
    }
}

fun JavaExec.run(profile: String) {
    classpath = sourceSets["main"].runtimeClasspath
    main = "com.sandstonelauncher.MainKt"
    systemProperty(str("environment.variable.profile"), profile)
}

task("runDev", JavaExec::class) {
    run(str("profile.dev"))
}

task("runProd", JavaExec::class) {
    run(str("profile.prod"))
}

tasks.withType(Test::class) {
    useJUnitPlatform()
    systemProperty(str("environment.variable.profile"), str("profile.test"))
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
