plugins {
    java
    id("com.diffplug.spotless")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

group = "one.zub.design-pattern-examples"
version = "1.0-SNAPSHOT"

spotless {
    java {
        googleJavaFormat("1.15.0").aosp().reflowLongStrings()
    }
}