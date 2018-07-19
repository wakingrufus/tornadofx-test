package com.wakingrufus.tornadofxtest

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class TestUtilTest {
    @Test
    fun `test waitFor`() {
        assertTrue(
                actual = waitFor(
                        maxMillis = 100,
                        condition = {
                            Thread.sleep(99)
                            true
                        }),
                message = "returns true after condition is true")

        assertFalse(
                actual = waitFor(
                        maxMillis = 100,
                        condition = { false },
                        sleepDuration = 10),
                message = "returns false if condition never passes")
    }
}