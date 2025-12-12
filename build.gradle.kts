plugins {
    java
    alias(libs.plugins.fabric.loom)
    alias(libs.plugins.shadow)
}
base {
    archivesName.set("fabric-mod-template")
}

version = System.getenv("TAG_VERSION") ?: "dev"
group = project.property("maven_group") as String

repositories {
}

loom {

}

dependencies {
    minecraft(libs.minecraft.get())
    mappings(loom.officialMojangMappings())
    modImplementation(libs.fabric.loader)
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand("version" to version)
        }
    }

    compileJava {
        options.release.set(21)
    }

    java {
        withSourcesJar()

        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    jar{
        inputs.property("archivesName", project.base.archivesName)

        from("LICENSE"){
            rename{ "${it}_${property("archivesName")}"}
        }
    }

}