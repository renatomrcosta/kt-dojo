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
    // RX Java 2 Dependencies
    implementation("io.reactivex.rxjava2:rxjava:2.2.14")

    // Reactor Dependencies
    implementation(platform("io.projectreactor:reactor-bom:2020.0.5"))
    implementation("io.projectreactor:reactor-core")

}
