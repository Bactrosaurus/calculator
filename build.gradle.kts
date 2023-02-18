import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.8.0"
    id("org.jetbrains.compose") version "1.3.0"
}

group = "de.daniel"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.mariuszgromada.math:MathParser.org-mXparser:5.1.0")
}

compose.desktop {
    application {
        mainClass = "de.daniel.calculator.CalculatorKt"
        nativeDistributions {
            packageName = "Calculator"
            packageVersion = "$version"
            targetFormats(TargetFormat.Msi, TargetFormat.Dmg, TargetFormat.Deb)
        }
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}