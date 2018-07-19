package com.wakingrufus.tornadofxtest

import mu.KLogging
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxAssert.verifyThat
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.matcher.control.LabeledMatchers.hasText

@ExtendWith(ApplicationExtension::class)
class TestFragmentTest : TornadoFxTest() {
    companion object : KLogging()

    @Test
    fun test() {
        showViewWithParams<TestFragment>(mapOf("string" to "string"))

        verifyThat("#label", hasText("string"))
    }
}