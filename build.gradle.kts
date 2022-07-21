import io.gitlab.arturbosch.detekt.Detekt

plugins {
	kotlin("jvm") version "1.7.10"
	id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

group = "dev.jimmymorales"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

kotlin {
	jvmToolchain {
		languageVersion.set(JavaLanguageVersion.of(18))
		vendor.set(JvmVendorSpec.AZUL)
	}
}

val detektJvmVersion = JavaVersion.VERSION_1_8.toString()
tasks.withType<Detekt>().configureEach {
	jvmTarget = detektJvmVersion
}
tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
	jvmTarget = detektJvmVersion
}
