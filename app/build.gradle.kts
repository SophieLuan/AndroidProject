// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    // Add the Google Services Gradle plugin
    id("com.google.gms.google-services") version "4.3.15" apply false
}


