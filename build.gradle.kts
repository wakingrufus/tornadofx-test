plugins {
    idea
}

task<Wrapper>("wrapper") {
    gradleVersion = "4.8.1"
}

allprojects {
    group = "com.github.wakingrufus.tornadofxtest"
}