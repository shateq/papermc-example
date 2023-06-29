plugins {
    java
    id("xyz.jpenilla.run-paper") version "2.1.0" // test plugin from your IDE using project server
}

group = "io.papermc"
version = "1.0.0"
description = "Example plugin using PaperMC software"

base {
    archivesName.set("example-plugin-paper-only")
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")
    implementation("org.bstats:bstats-bukkit:3.0.1") // bStats - as you like it
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    // withSourcesJar()
}

tasks {
    assemble {
        dependsOn(clean)
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }

    processResources {
        filteringCharset = Charsets.UTF_8.name()
        // Token replacing
        val props = mapOf(
            "version" to version,
            "desc" to project.description,
            "apiVersion" to "1.20"
        )
        inputs.properties(props)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }

    jar {
        from("LICENSE") {
            rename { "LICENSE_${rootProject.name}" }
        }
    }
}
