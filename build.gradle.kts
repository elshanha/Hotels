// Top-level build file where you can add configuration options common to all sub-projects/modules.

dependencies {
Classpath.navArgs
}

plugins {
    id(Plugins.androidApplication) version Versions.androidApplication apply false
    id(Plugins.jetBrainsKotlin) version Versions.jetbrainsKotlinAndroid apply false
    id(Classpath.hilt) version Versions.hilt apply false
    id(Plugins.gmsGoogleServices) version Versions.gmsGoogleServices apply false
    id(Plugins.androidLibrary) version Versions.androidLib apply false
    id(Plugins.firebaseChraslytics) version Versions.chraslytics apply false
}