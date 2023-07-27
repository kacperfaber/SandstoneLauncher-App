package com.sandstonelauncher

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class CurrentProfileTest {
    @Test
    fun `toProfile throws when given value is not TEST,PROD,DEV`() {
        assertThrows<CurrentProfile.InvalidProfileException> { CurrentProfile.toProfile("abc") }
        assertThrows<CurrentProfile.InvalidProfileException> { CurrentProfile.toProfile("123") }
        assertThrows<CurrentProfile.InvalidProfileException> { CurrentProfile.toProfile("jebac-disa") }
    }
    
    @Test
    fun `toProfile does not throw when given is valid profile from SharedConstants`() {
        assertDoesNotThrow { CurrentProfile.toProfile(SharedConstants.Profiles.TEST) }
        assertDoesNotThrow { CurrentProfile.toProfile(SharedConstants.Profiles.PROD) }
        assertDoesNotThrow { CurrentProfile.toProfile(SharedConstants.Profiles.DEV) }
    }
    
    @Test
    fun `toProfile does not throw when given is valid profile from SharedConstants but lowercase`() {
        assertDoesNotThrow { CurrentProfile.toProfile(SharedConstants.Profiles.TEST.lowercase()) }
        assertDoesNotThrow { CurrentProfile.toProfile(SharedConstants.Profiles.PROD.lowercase()) }
        assertDoesNotThrow { CurrentProfile.toProfile(SharedConstants.Profiles.DEV.lowercase()) }
    }

    @Test
    fun `toProfile returns expected when given is SharedConstants-Profiles-TEST`() {
        assertEquals(Profile.TEST, CurrentProfile.toProfile(SharedConstants.Profiles.TEST))
    }

    @Test
    fun `toProfile returns expected when given is SharedConstants-Profiles-PROD`() {
        assertEquals(Profile.PROD, CurrentProfile.toProfile(SharedConstants.Profiles.PROD))
    }

    @Test
    fun `toProfile returns expected when given is SharedConstants-Profiles-DEV`() {
        assertEquals(Profile.DEV, CurrentProfile.toProfile(SharedConstants.Profiles.DEV))
    }

    @Test
    fun `toProfile returns expected when given is SharedConstants-Profiles-TEST but lowercase`() {
        assertEquals(Profile.TEST, CurrentProfile.toProfile(SharedConstants.Profiles.TEST.lowercase()))
    }

    @Test
    fun `toProfile returns expected when given is SharedConstants-Profiles-PROD but lowercase`() {
        assertEquals(Profile.PROD, CurrentProfile.toProfile(SharedConstants.Profiles.PROD.lowercase()))
    }

    @Test
    fun `toProfile returns expected when given is SharedConstants-Profiles-DEV but lowercase`() {
        assertEquals(Profile.DEV, CurrentProfile.toProfile(SharedConstants.Profiles.DEV.lowercase()))
    }
}