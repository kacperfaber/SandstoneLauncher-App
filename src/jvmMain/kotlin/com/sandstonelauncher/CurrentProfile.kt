package com.sandstonelauncher

enum class Profile(val value: String) {
    TEST(SharedConstants.Profiles.TEST),
    DEV(SharedConstants.Profiles.DEV),
    PROD(SharedConstants.Profiles.PROD)
}

private fun String.toProfile(): Profile = try {Profile.valueOf(this)} catch (e: IllegalArgumentException) {
    throw Exception("$this cannot be a profile. Possible values are TEST,PROD,DEV")
}

val currentProfile: Profile
    get() = System.getProperty(SharedConstants.EnvVar.CURRENT_PROFILE).toProfile()