rootProject.name = "Raphtalia"

include(
    ":client",
    ":common"
)

include(
    ":discord:commands",
    ":discord:gateway"
)

include(
    ":website:api",
    ":website:auth"
)

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val kotlin = version("kotlin", "1.6.20")
            val kord = version("kord", "0.8.x-SNAPSHOT")

            library("kord-rest", "dev.kord", "kord-rest").versionRef(kord)
            library("kord-gateway", "dev.kord", "kord-gateway").versionRef(kord)
        }
    }
}