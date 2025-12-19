// Example Gradle build configuration for MES Client
// build.gradle.kts

plugins {
    id("org.jetbrains.intellij") version "1.17.0"
    java
    kotlin("jvm") version "1.9.0"
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    // Add your MES-specific dependencies here
    // implementation("com.example:mes-api:1.0.0")
    // implementation("com.squareup.okhttp3:okhttp:4.12.0")
    // implementation("com.google.code.gson:gson:2.10.1")
}

intellij {
    version.set("2024.1")
    type.set("IC") // IntelliJ IDEA Community
    
    // Include only the platform modules you need
    plugins.set(listOf(
        // Add plugins if needed, e.g., "java"
    ))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("241")
        untilBuild.set("243.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
    
    // Build standalone application
    buildSearchableOptions {
        enabled = false
    }
    
    runIde {
        // Set custom IDE arguments
        args = listOf("--mes-client")
    }
}
