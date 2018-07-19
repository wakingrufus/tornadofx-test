package com.wakingrufus.tornadofxtest

import mu.KLogging
import tornadofx.Fragment
import tornadofx.label
import tornadofx.vbox

class TestFragment : Fragment() {
    companion object : KLogging()

    val string: String by param()

    override val root = vbox {
        label(string){
            id = "label"
        }
    }
}
