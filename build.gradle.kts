import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.31"))
    }
}

plugins {
    application
    kotlin("jvm") version "1.3.11"
}

group = "cpk.cpkmusic"
version = "1.0-SNAPSHOT"

configure<ApplicationPluginConvention> {
    mainClassName = "cpk.cpkmusic.Main"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}