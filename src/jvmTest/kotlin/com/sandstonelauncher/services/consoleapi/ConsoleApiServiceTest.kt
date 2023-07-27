package com.sandstonelauncher.services.consoleapi

import com.sandstonelauncher.data.LauncherProfile
import com.sandstonelauncher.data.Resolution
import com.sandstonelauncher.services.consoleapi.wrapper.ConsoleApiWrapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.koin.java.KoinJavaComponent.inject
import org.mockito.kotlin.whenever
import testutils.BaseDiTest
import testutils.testSuspend
import kotlin.test.assertEquals

class ConsoleApiServiceTest : BaseDiTest() {
    private val consoleApiService by inject<ConsoleApiService>(ConsoleApiService::class.java)

    @Test
    fun `getLauncherProfiles does not throw`() = testSuspend {
        createMock<ConsoleApiWrapper> {
            whenever(it.listProfiles()).thenReturn(listOf())
        }

        assertDoesNotThrow { consoleApiService.getLauncherProfiles() }
    }

    @Test
    fun `getLauncherProfiles returns what ConsoleApiWrapper-listProfiles returned`() = testSuspend {
        val expectedList = listOf(
            LauncherProfile(
                "kacperek",
                "%APPDATA%\\.minecraft",
                "C:\\Users\\kacperfaber",
                "",
                Resolution(854, 480),
                "1.19.2"
            )
        )

        createMock<ConsoleApiWrapper> {
            whenever(it.listProfiles()).thenReturn(expectedList)
        }

        assertEquals(expectedList, consoleApiService.getLauncherProfiles())
    }
}