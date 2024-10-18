plugins {
    kotlin("jvm") version "1.9.25"

    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"

    id("org.openapi.generator") version "7.1.0"
    id("org.liquibase.gradle") version "2.2.0"
    kotlin("plugin.jpa") version "1.9.25"
}

group = "ru.bardinpetr.itmo"
version = "0.1.0"


configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // web
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.springframework.session:spring-session-jdbc")

    // data
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa"  )
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.modelmapper:modelmapper:3.2.0")
    implementation("org.hibernate:hibernate-envers:7.0.0.Beta1")
//    implementation("org.springframework.data:spring-data-envers")

    // security
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-data-ldap")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-oauth2-jose")
    implementation("org.keycloak.bom:keycloak-adapter-bom:22.0.5")

    // docs
    implementation("org.springdoc:springdoc-openapi-starter-common:2.2.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

    // misc
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
//    developmentOnly("org.springframework.boot:spring-boot-starter-actuator")

    // tests
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

openApiGenerate {
    generatorName = "typescript-angular"
    inputSpec = "$rootDir/openapi.yaml"
    outputDir = "${layout.buildDirectory.get()}/client"
    additionalProperties.apply {
        put("packageName", "lab1api")
    }
    configOptions.apply {
        put("npmName", "itmo-is-lab1")
        put("npmRepository", "https://github.com/BardinPetr/itmo-is-lab-1-server")
    }
}
