plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.zora_shape"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.zora_shape"
        minSdk = 24
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.glide)

    // ========== TAMBAHAN UNTUK PERTEMUAN 10 ==========

    // RecyclerView - untuk menampilkan list/grid produk
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // ViewPager2 - untuk swipe antar tab
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // Material Design - untuk TabLayout (sebenarnya sudah dari libs.material)
    // Tapi pastikan versionnya support, jika perlu tambahkan:
    // implementation("com.google.android.material:material:1.9.0")

    // Glide - untuk loading gambar (sudah ada dari libs.glide)
    // Tapi jika libs.glide tidak bekerja, bisa pakai ini:
    // implementation("com.github.bumptech.glide:glide:4.16.0")

    // ========== END TAMBAHAN ==========

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}