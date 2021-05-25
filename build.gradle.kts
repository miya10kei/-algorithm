import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.5.0"
  id("application")
  id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
}

group = "com.miya10kei.algorithms"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib")

  testImplementation("org.assertj:assertj-core:3.19.0")
  testImplementation(kotlin("test-junit5"))
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}

ktlint {
  version.set("0.41.0")
  outputColorName.set("RED")
  additionalEditorconfigFile.set(File(".editorconfig"))
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
