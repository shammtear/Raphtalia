package com.arthurph.raphtalia.common

import org.json.JSONObject
import java.nio.file.Files

object Config {
    object Env {
        private var data: JSONObject? = null
        fun load() {
            //print(java.io.File(".\\").listFiles()?.map { file -> file.name })
            val file = java.io.File(".\\assets\\raphtalia.json").absoluteFile
            if (!file.exists()) {
                if (!java.io.File(".\\assets\\example\\raphtalia.json").absoluteFile.exists()) {
                    error(
                        "\nHi, my name is Raphtalia, looks like we're not in a good situation right now, you don't have a configuration file located in the path \"./assets\".\nAnd the file(\"./assets/examples/raphtalia.json\") used for create config file disappeared, i swear i searched for it but no success.\nI ask you to redownload Raphtalia or add the necessary file\n" +
                                "See you later"
                    )
                }
                Files.copy(
                    java.io.File(".\\assets\\example\\raphtalia.json").toPath(),
                    java.io.File("./assets").toPath()
                )
                error("\nHi!\nMy name is Raphtalia\nI noticed that there was no configuration file, so I created one for you, it is located in \"./Assets/raphtalia.json\".\nAfter filling in the necessary data, run me again.\nI hope to see you soon")
            }

            data = JSONObject(File.read(file.path))
        }

        fun getValue(env: String): Any {
            data ?: error("Could not access configuration data, bug ?")
            val envParam = env.split(".")
            return data!!.getJSONObject(envParam[0]).get(envParam[1])
        }
    }
}