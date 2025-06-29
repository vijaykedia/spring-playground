plugins { id("spring-conventions") }

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  runtimeOnly("com.h2database:h2")
  implementation(libs.infinispan)
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}
