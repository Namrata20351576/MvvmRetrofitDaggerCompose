plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.nams.mvvmretrofitdaggercompose"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.nams.mvvmretrofitdaggercompose"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    buildFeatures {
        compose = true
        dataBinding = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=enable")
    }
    allprojects {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_1_8.toString()
            }
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.compose.material:material:1.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")

    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    val hilt_version = "2.44"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    //recyclerview
    implementation("androidx.recyclerview:recyclerview:1.1.0")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.13.0")

    val coroutines_version = "1.6.4"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version")

    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //url image support in Jetpack compose
    implementation("io.coil-kt:coil-compose:2.4.0")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")
    //
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    testImplementation("org.mockito:mockito-core:3.6.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
    testImplementation("org.mockito:mockito-inline:5.2.0")

}
