plugins {
    java
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "life.thedeveloper"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springAiVersion"] = "0.8.1"

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("org.flywaydb:flyway-core")
    implementation("org.springframework.ai:spring-ai-openai-spring-boot-starter")
    implementation("com.google.guava:guava:33.1.0-jre")

//    implementation("org.springframework.boot:spring-boot-starter-security:3.2.4")
//    implementation("org.springframework.security:spring-security-oauth2-jose:6.2.3")
//    implementation("org.springframework.security:spring-security-oauth2-resource-server:6.2.3")

//    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("com.h2database:h2:2.2.224")

    compileOnly("org.springframework.boot:spring-boot-devtools")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.ai:spring-ai-bom:${property("springAiVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
