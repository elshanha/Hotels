plugins {
    id(Plugins.androidLibrary)
    id(Plugins.jetBrainsKotlin)
    id(Plugins.firebaseChraslytics)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
    id(Plugins.gmsGoogleServices)
}

android {
    namespace = "com.example.hotels"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
    dataBinding {
        enable = true
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))
    implementation(project(":entities"))

    implementation (Libs.Firebase.googleAuth)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltKapt)

    implementation(platform(Libs.Firebase.firebaseBom))
    implementation(Libs.Firebase.firebaseAuth)
    implementation(Libs.Firebase.firebaseCharsLytics)
    implementation(Libs.Navigation.navigationFragment)
    implementation(Libs.Navigation.navigationUi)
    implementation(Libs.UI.material)

    implementation(Libs.UI.lottie)
    implementation(Libs.UI.coil)

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}