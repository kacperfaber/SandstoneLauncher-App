package testutils

import kotlinx.coroutines.runBlocking

fun testSuspend(act: suspend ()->Unit) {
    runBlocking { act() }
}