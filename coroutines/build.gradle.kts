plugins {
    kotlin("jvm") version "1.4.31"
}

group = "com.xunfos.dojo"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.4.3")
    implementation("io.reactivex.rxjava2:rxjava:2.2.14")
}
