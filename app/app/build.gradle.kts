plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.smartcityapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.smartcityapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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


    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    implementation("com.google.firebase:firebase-storage:20.0.0")
    implementation("com.google.firebase:firebase-auth:22.0.0")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.gson)
    implementation("com.google.firebase:firebase-database:21.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.activity:activity:1.9.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation(libs.firebase.firestore)
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.google.firebase:firebase-storage:21.0.1")

    implementation ("com.github.bumptech.glide:glide:4.12.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation(libs.core)
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    testImplementation ("org.mockito:mockito-core:3.11.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    //testImplementation ("org.robolectric:robolectric:4.7.3")

    testImplementation("org.robolectric:robolectric:4.10.3")






    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}
