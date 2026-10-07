plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "com.clinicapets"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
    jvmArgs("-Dfile.encoding=UTF-8")
}

kotlin {
    jvmToolchain(23)
}

application {
    mainClass.set("com.clinicapets.MainKt")
}
