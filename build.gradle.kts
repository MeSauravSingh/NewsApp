// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")
        //DaggerHilt
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
        classpath ("com.android.tools.build:gradle:8.1.4")
    }
}

plugins {

    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false

}