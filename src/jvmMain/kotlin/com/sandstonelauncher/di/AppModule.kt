package com.sandstonelauncher.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.sandstonelauncher")
class AppModule

@Single
class MakeModuleNotEmpty