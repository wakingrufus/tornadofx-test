package com.wakingrufus.tornadofxtest

import javafx.application.Platform
import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import mu.KLogging
import org.testfx.framework.junit.ApplicationTest
import tornadofx.UIComponent
import tornadofx.View
import tornadofx.stackpane
import java.time.Instant

open class TornadoFxTest : ApplicationTest() {
    companion object : KLogging()

    lateinit var wrapper: TestView
    var scene: Scene? = null

    override fun start(stage: Stage) {
        wrapper = TestView()
        scene = Scene(wrapper.root, 800.0, 600.0)
        stage.scene = scene
        stage.show()
    }

    protected inline fun <reified T : UIComponent> showViewWithParams(params: Map<*, Any?>?) = wrapper.addViewWithParams<T>(params)

    class TestView : View() {
        override val root = stackpane { }
        inline fun <reified T : UIComponent> findView(params: Map<*, Any?>?) = find<T>(params)
        inline fun <reified T : UIComponent> addViewWithParams(params: Map<*, Any?>?) {
            Platform.runLater {
                root.add(findView<T>(params))
            }
            waitFor(condition = { root.children.size > 0 })
        }
    }
}

fun waitFor(condition: () -> Boolean, maxMillis: Long = 10000) {
    val startTime = Instant.now()
    while (!condition() && Instant.now().isBefore(startTime.plusMillis(maxMillis))) {
        Thread.sleep(1000)
    }
}

val logger = KLogging().logger()
fun printNodes(node: Node, level: Int = 0) {

    logger.info { " ".repeat(level) + node.toString() }
    if (node is Parent) {
        node.childrenUnmodifiable.forEach {
            printNodes(it, level + 1)
        }
    }

}