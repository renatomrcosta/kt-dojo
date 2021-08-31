import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
}

group = "com.xunfos.dojo"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_16


repositories {
    mavenCentral()
}

dependencies {
    val kotestVersion = "4.6.1"
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1-native-mt")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.5.1-native-mt")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.5.1-native-mt")
    // RX Java 2 Dependencies
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    // Reactor Dependencies
    implementation(platform("io.projectreactor:reactor-bom:2020.0.5"))
    implementation("io.projectreactor:reactor-core")

    // Test Dependencies
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")

    testImplementation("io.mockk:mockk:1.12.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "16"
    }
}
