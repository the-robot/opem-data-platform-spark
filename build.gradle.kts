plugins {
    id("java")
}

group = "com.odp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.spark:spark-sql_2.12:3.5.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Jar>("createJar") {
    from(sourceSets.main.get().output)
    archiveBaseName.set("com.odp.spark") // Replace with your desired JAR file name
    destinationDirectory.set(file("build/libs"))
}

tasks.build {
    dependsOn(tasks.named("createJar"))
}
