plugins {
    id("com.android.application") version "8.4.0" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("com.google.dagger.hilt.android") version "2.42" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

buildscript {

    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.37")

    }
}
