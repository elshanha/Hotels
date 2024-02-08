object Versions {
    const val androidApplication = "8.2.2"
    const val jetbrainsKotlinAndroid = "1.9.22"
    const val gmsGoogleServices = "4.4.0"
    const val materialComponents = "1.11.0"
    const val hilt = "2.46"
    const val navigation = "2.7.6"
    const val androidLib = "8.2.2"
    const val firebaseBom = "32.7.1"
    const val lottie = "6.3.0"
    const val retrofit = "2.9.0"
    const val okhttpLogging = "4.10.0"
    const val okhttp = "5.0.0-alpha.3"
    const val gson = "2.10.1"
    const val splashScreen = "1.0.0"
    const val room = "2.6.1"
    const val chraslytics = "2.9.9"
    const val navArgs = "2.7.6"
    const val coil = "2.5.0"
    const val googleAuth = "20.7.0"
}

object Libs {

    object Firebase {

        const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
        const val firebaseAnalytic = "com.google.firebase:firebase-analytics"
        const val firebaseMessaging = "com.google.firebase:firebase-messaging"
        const val firebaseAuth = "com.google.firebase:firebase-auth"
        const val firebaseFireStore = "com.google.firebase:firebase-firestore"
        const val firebaseCharsLytics = "com.google.firebase:firebase-crashlytics"
        const val googleAuth = "com.google.android.gms:play-services-auth:${Versions.googleAuth}"


    }

    object UI {
        const val material = "com.google.android.material:material:${Versions.materialComponents}"
        const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
        const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"
        const val coil = "io.coil-kt:coil:${Versions.coil}"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Api {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okhttpLogging =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
    }

    object Navigation {
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Room {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomKapt = "androidx.room:room-compiler:${Versions.room}"
    }

}

object Plugins {

    const val androidApplication = "com.android.application"
    const val jetBrainsKotlin = "org.jetbrains.kotlin.android"
    const val hilt = "com.google.dagger.hilt.android"
    const val kotlinKapt = "kotlin-kapt"
    const val parcelize = "kotlin-parcelize"
    const val gmsGoogleServices = "com.google.gms.google-services"
    const val androidLibrary = "com.android.library"
    const val firebaseChraslytics = "com.google.firebase.crashlytics"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"

}

object Classpath {
    const val hilt = "com.google.dagger.hilt.android"
    const val crashlytics = "com.google.firebase.crashlytics"
    const val navArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navArgs}"

}