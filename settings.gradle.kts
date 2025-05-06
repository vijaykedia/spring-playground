rootProject.name = "spring-playground"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

val excludedDirectories = listOf("build", "buildSrc")
fun registerAsModule(parent: File) {
    parent.listFiles()?.filter { it.isDirectory }?.filter { it.name !in excludedDirectories }?.filter { !it.name.startsWith(".")}?.forEach {
        if (File(it, "build.gradle.kts").exists()) {
            include(it.name)
            project(":" + it.name).projectDir = it
        } else {
            registerAsModule(it)
        }
    }
}
registerAsModule(rootDir)
