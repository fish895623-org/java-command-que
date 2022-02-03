import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot") version "2.6.1"
  id("io.spring.dependency-management") version "1.0.11.RELEASE" apply true
  id("java")
}

group = "com.github.fish895623"
version = "0.0.102"

tasks {
  withType<BootJar> {
    archiveBaseName.set("command")
    archiveVersion.set("")
  }
}

repositories {
  mavenCentral()
}

configurations {
  all {
    exclude(
      group = "org.springframework.boot",
      module = "spring-boot-starter-logging"
    )
  }
}

dependencies {
  implementation("org.xerial:sqlite-jdbc:3.36.0.2")
  implementation("org.apache.logging.log4j:log4j-core:2.17.0")
  implementation("org.apache.logging.log4j:log4j-api:2.17.0")
  implementation("org.springframework.boot:spring-boot-starter-log4j2:2.6.3")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.1")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.13.1")
  implementation("org.springframework.boot:spring-boot-starter-web:2.6.3")
  developmentOnly("org.springframework.boot:spring-boot-devtools:2.6.3")
  testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.3")
}

tasks.test {
  useJUnitPlatform()
}
