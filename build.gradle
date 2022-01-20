plugins {
    id("java")
}

group = project.maven_group
version = project.version

repositories {
    mavenCentral()
    maven { url "https://papermc.io/repo/repository/maven-public/" }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
    // bStats - if you'd like
    implementation("org.bstats:bstats-bukkit:2.2.1")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    // withSourcesJar()
}

tasks {
    compileJava {
        options.encoding = "UTF-8" // Must have!
        options.release.set(17) // Java 17 for versions 1.18+
    }

    processResources {
        filteringCharset = "UTF-8" // Must have!

        // Versioning or other variables.
        filesMatching("plugin.yml") {
            expand "version": project.version
        }
    }

    jar {
        from("LICENSE") {
            rename { "LICENSE_${rootProject.name}" }
        }
    }
}
