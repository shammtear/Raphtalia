plugins {
    kotlin("jvm")
    application
}

dependencies {
    api(project(":common"))
    api(libs.kord.gateway)
    api(libs.kord.rest)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("com.arthurph.raphtalia.gateway.RaphtaliaLauncherKt")
}