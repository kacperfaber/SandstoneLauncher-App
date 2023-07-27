package com.sandstonelauncher

import androidx.compose.ui.text.toUpperCase

enum class Profile(val value: String) {
    TEST(SharedConstants.Profiles.TEST),
    DEV(SharedConstants.Profiles.DEV),
    PROD(SharedConstants.Profiles.PROD)
}

class CurrentProfile {
    class InvalidProfileException : Exception()

    companion object {
        internal fun toProfile(profile: String): Profile = try {Profile.valueOf(profile.uppercase())} catch (e: IllegalArgumentException) {
            throw InvalidProfileException()
        }
    }
}

val currentProfile: Profile
    get() = CurrentProfile.toProfile(System.getProperty(SharedConstants.EnvVar.CURRENT_PROFILE))