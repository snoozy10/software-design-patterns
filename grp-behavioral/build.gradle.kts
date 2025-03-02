plugins {
    id("java")
    id("application")
}

group = "io.github.snoozy10.softwarepatterns"
version = "1.0-SNAPSHOT"

subprojects {
    apply(plugin = "application")

    // Get main class from gradle.properties if defined, otherwise use default
    val defaultMainClass = "io.github.snoozy10.softwarepatterns.Main"

    configure<JavaApplication> {
        mainClass.set(project.findProperty("mainClass.$name") as String? ?: defaultMainClass)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
