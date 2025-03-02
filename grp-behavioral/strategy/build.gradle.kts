plugins {
    id("java")
}

group = "io.github.snoozy10.softwarepatterns"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("io.github.snoozy10.softwarepatterns.StrategyPatternDemo")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
