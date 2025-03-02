rootProject.name = "software-design-patterns"

// Include all parent modules (structural, creational, behavioral)
include(":grp-structural")
// Dynamically include all subprojects (design patterns)
file("grp-structural").listFiles()?.forEach { dir ->
    if (dir.isDirectory) include(":grp-structural:${dir.name}")
}

include(":grp-behavioral")
file("grp-behavioral").listFiles()?.forEach { dir ->
    if (dir.isDirectory) include(":grp-behavioral:${dir.name}")
}
