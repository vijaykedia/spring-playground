plugins { id("spring-conventions") }

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation(libs.infinispan)
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}
