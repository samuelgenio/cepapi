import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {

	repositories {
		mavenCentral()
		maven { setUrl("https://repo.spring.io/milestone") }
	}

	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M2")
		classpath(kotlin("gradle-plugin"))
	}
}

plugins {
	id("org.springframework.boot") version "2.7.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.samuel"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

val kotlinLoggingVersion: String by project
val retrofitVersion: String by project
val springfoxVersion: String by project

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	//swagger
	implementation("io.springfox:springfox-boot-starter:$springfoxVersion")

	//retrofit
	implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
	implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

	//logger
	implementation ("io.github.microutils:kotlin-logging-jvm:$kotlinLoggingVersion")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}