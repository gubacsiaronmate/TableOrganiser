// Top-level build file where you can add configuration options common to all subprojects/modules.
plugins {
    id("com.android.application") version "8.10.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.21" apply false
}

buildscript {
    val objectboxVersion by extra("4.3.0") // For KTS build scripts
    
    repositories {
        mavenCentral()
    }
    
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath("io.objectbox:objectbox-gradle-plugin:$objectboxVersion")
    }
}