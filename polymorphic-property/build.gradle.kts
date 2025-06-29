plugins { id("spring-conventions") }

dependencies {
  implementation("org.springframework.boot:spring-boot-autoconfigure")
  implementation("org.yaml:snakeyaml:2.4")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.19.1")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.19.1")
}
