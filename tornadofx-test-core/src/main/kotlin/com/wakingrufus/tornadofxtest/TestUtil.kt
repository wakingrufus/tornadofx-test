package com.wakingrufus.tornadofxtest

import javafx.scene.Node
import javafx.scene.Parent
import mu.KLogging
import java.time.Instant

fun waitFor(condition: () -> Boolean, maxMillis: Long = 10000, sleepDuration: Long = 1000): Boolean {
    val startTime = Instant.now()
    var c: Boolean = condition()
    while (!c && Instant.now().isBefore(startTime.plusMillis(maxMillis))) {
        Thread.sleep(sleepDuration)
        c = condition()
    }
    return c
}

fun printNodes(node: Node,
               level: Int = 0,
               printer: (String) -> Unit = KLogging().logger()::info) {

    printer(" ".repeat(level) + node.toString())
    if (node is Parent) {
        node.childrenUnmodifiable.forEach {
            printNodes(it, level + 1)
        }
    }

}