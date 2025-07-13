package com.example.composemvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * MyApplication
 *
 * This is the base Application class for the app.
 * Annotated with @HiltAndroidApp to trigger Hilt’s code generation,
 * including a base class for your application that can be used to
 * inject dependencies across the entire app lifecycle.
 *
 * Required for setting up Hilt in any Android project.
 */
@HiltAndroidApp
class MyApplication : Application()
