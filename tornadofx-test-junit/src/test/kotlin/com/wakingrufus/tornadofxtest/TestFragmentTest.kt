package com.wakingrufus.tornadofxtest

import mu.KLogging
import org.junit.Test
import org.testfx.api.FxAssert.verifyThat
import org.testfx.matcher.control.LabeledMatchers.hasText

class TestFragmentTest : TornadoFxTest() {
    companion object : KLogging()

    @Test
    fun test() {
        showViewWithParams<TestFragment>(mapOf("string" to "string"))

        verifyThat("#label", hasText("string"))
    }
}