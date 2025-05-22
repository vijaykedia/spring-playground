plugins {
    java
    alias(libs.plugins.spring.boot)
    id("com.diffplug.spotless")
}

dependencies {
    implementation(platform(libs.spring.boot.deps))
    implementation(libs.jetbrains.annotations)

    testImplementation("org.springframework.boot:spring-boot-test-autoconfigure")
}

spotless {
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
        ktfmt().googleStyle()
    }
    kotlin {
        target("src/*/kotlin/**/*.kt")
        ktlint()
        ktfmt().googleStyle()
    }
    java {
        target("src/*/java/**/*.java")
        googleJavaFormat()
    }
    flexmark {
        target("**/*.md")
    }
}

tasks.withType<JavaCompile> {
    dependsOn(tasks.named ("spotlessApply"))
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
