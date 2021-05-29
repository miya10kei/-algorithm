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
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")

  testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
  testImplementation("org.assertj:assertj-core:3.19.0")
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
