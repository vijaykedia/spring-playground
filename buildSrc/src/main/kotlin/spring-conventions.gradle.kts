plugins {
    alias(libs.plugins.spring.boot)
    id("com.diffplug.spotless")
}

spotless {
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
        ktfmt()
    }
    kotlin {
        target("src/*/kotlin/**/*.kt")
        ktlint()
        ktfmt()
    }
    java {
        target("src/*/java/**/*.java")
        googleJavaFormat()
    }
}

tasks.named("build") {
    dependsOn("spotlessApply")
}
