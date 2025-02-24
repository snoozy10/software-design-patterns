rootProject.name = "software-design-patterns"

// Include all parent modules (structural, creational, behavioral)
include(":structural")

// Dynamically include all subprojects (design patterns)
file("structural").listFiles()?.forEach { dir ->
    if (dir.isDirectory) include(":structural:${dir.name}")
}

