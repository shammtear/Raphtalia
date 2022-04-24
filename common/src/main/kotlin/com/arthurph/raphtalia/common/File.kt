package com.arthurph.raphtalia.common

import java.io.*

object File {
    fun read(path: String): String {
        val buffer = BufferedReader(
            FileReader(
                File(path).absoluteFile
            )
        )
        var content = ""
        var line = buffer.readLine()
        while(line !== null) {
            content += "$line\n"
            line = buffer.readLine()
        }

        return content
    }

    fun write(path: String, content: String) {
        BufferedWriter(FileWriter(File(path).absoluteFile)).also {
            it.write(content)
        }.close()
    }
}