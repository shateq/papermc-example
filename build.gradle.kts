plugins {
    java
    kotlin("jvm") version "1.6.20"
    // Shading in the Kotlin standard library
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.papermc"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
    // bStats - if you'd like
    implementation("org.bstats:bstats-bukkit:3.0.0")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    // withSourcesJar()
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8" // Must have!
        options.release.set(17) // Java 17 for versions 1.18+
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    processResources {
        filteringCharset = "UTF-8" // Must have!

        // Token replacing
        filesMatching("plugin.yml") {
            expand("version" to version)
        }
    }

    jar {
        from("LICENSE") {
            rename { "LICENSE_${rootProject.name}" }
        }
    }
}
