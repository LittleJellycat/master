import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
}

group = "jelly"
version = "1.0-SNAPSHOT"

arrow_version = "0.9.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("io.arrow-kt:arrow-core-data:$arrow_version"))
    compile(kotlin("io.arrow-kt:arrow-syntax:$arrow_version"))
    compile(kotlin("io.arrow-kt:arrow-typeclasses:$arrow_version"))
    compile(kotlin("io.arrow-kt:arrow-extras:$arrow_version"))
    compile(kotlin("io.arrow-kt:arrow-core-extensions:$arrow_version"))
    compile(kotlin("io.arrow-kt:arrow-extras-extensions:$arrow_version"))
    kapt(kotlin("io.arrow-kt:arrow-meta:$arrow_version"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}