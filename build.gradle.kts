import io.gitlab.arturbosch.detekt.Detekt

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
	alias(libs.plugins.kotlin)
	alias(libs.plugins.detekt)
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

detekt {
	config = rootProject.files("config/detekt/detekt.yml")
}

val detektJvmVersion = JavaVersion.VERSION_1_8.toString()
tasks.withType<Detekt>().configureEach {
	jvmTarget = detektJvmVersion
}
tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
	jvmTarget = detektJvmVersion
}

tasks.withType<Test>().configureEach {
	useJUnitPlatform()
}

dependencies {
	detektPlugins(libs.detekt.formatting)

	implementation(libs.kotest.property)
	testImplementation(libs.bundles.kotest)
}
