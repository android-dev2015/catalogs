pluginManagement {
    val flutterSdkPath = run {
        val properties = java.util.Properties()
        file("local.properties").inputStream().use { properties.load(it) }
        val path = properties.getProperty("flutter.sdk")
        checkNotNull(path) { "flutter.sdk not set in local.properties" }
        path
    }
    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
//    id("dev.flutter.flutter-plugin-loader") version "1.0.0"
//    id("com.android.application") version "8.8.0-alpha09" apply false
//    id("org.jetbrains.kotlin.android") version "2.0.21" apply false

    //Not Support version catalogs
    //Error: Unresolved reference: libs
    //https://github.com/flutter/flutter/issues/158368
    alias(libs.plugins.flutterPluginLoader)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

include(":app")
