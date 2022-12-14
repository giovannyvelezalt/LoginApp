plugins {
  id("com.android.test")
  id("org.jetbrains.kotlin.android")
}

android {
  compileSdk = Configurations.compileSdk

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  defaultConfig {
    minSdk = 23
    targetSdk = Configurations.targetSdk
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    // This benchmark buildType is used for benchmarking, and should function like your
    // release build (for example, with minification on). It"s signed with a debug key
    // for easy local/CI testing.
    create("benchmark") {
      isDebuggable = true
      signingConfig = getByName("debug").signingConfig
      matchingFallbacks += listOf("release")
    }
  }

  targetProjectPath = ":app"
  experimentalProperties["android.experimental.self-instrumenting"] = true
}

dependencies {
  implementation(Dependencies.androidXTestRunner)
  implementation(Dependencies.macroBenchmark)
  implementation(Dependencies.profileInstaller)
  implementation(Dependencies.uiAutomator)
}

androidComponents {
  beforeVariants(selector().all()) {
    it.enabled = it.buildType == "benchmark"
  }
}
