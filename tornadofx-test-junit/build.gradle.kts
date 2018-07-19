plugins {
    kotlin("jvm") version "1.2.51"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.jetbrains.kotlin:kotlin-test")
    compile("no.tornado:tornadofx:1.7.12")
    compile("org.testfx:testfx-core:4.0.13-alpha")
    compile("io.github.microutils:kotlin-logging:1.4.4")

    compile("org.jetbrains.kotlin:kotlin-test-junit")
    listOf("slf4j-api", "slf4j-log4j12").forEach {
        testCompile(group = "org.slf4j", name = it, version = "1.7.25")
    }
    compile ("org.testfx:testfx-junit:4.0.13-alpha")

}

tasks.getByName<Test>("test") {
    useJUnit()
}