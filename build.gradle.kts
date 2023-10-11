import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.jlleitschuh.gradle.ktlint") version "11.6.0"

    kotlin("jvm") version "1.9.10"
    kotlin("kapt") version "1.9.10"

    kotlin("plugin.spring") version "1.9.10"
    kotlin("plugin.allopen") version "1.9.10"
    kotlin("plugin.jpa") version "1.9.10"
}

apply(plugin = "io.spring.dependency-management")
apply(plugin = "org.jlleitschuh.gradle.ktlint")

group = "com.park.basketball"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.1.1")
    }
}

dependencies {
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    // spring
    implementation("org.springframework.boot:spring-boot-starter")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("com.mysql:mysql-connector-j")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
    }
    testImplementation("com.ninja-squad:springmockk:3.0.1")

    implementation(platform("org.testcontainers:testcontainers-bom:1.19.1"))
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mysql")

    testImplementation("com.github.javafaker:javafaker:1.0.2") {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
}

configure<KtlintExtension> {
    version = "1.0.0"
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
