# clinicaPets

A clean and modern Kotlin starter project configured with Gradle (Kotlin DSL).

## 🚀 Features

- **Language:** Kotlin 2.1.0 with JVM Toolchain (Java 23)
- **Build Tool:** Gradle with Kotlin DSL (`build.gradle.kts`)
- **Testing:** `kotlin.test` with JUnit Platform
- **Gradle Wrapper:** Bundled (`gradlew` / `gradlew.bat`), no prior Gradle installation required

## 📂 Project Structure

```
clinicaPets/
├── build.gradle.kts              # Gradle build script (Kotlin DSL)
├── settings.gradle.kts           # Gradle settings
├── gradlew / gradlew.bat         # Gradle wrapper executable scripts
├── gradle/wrapper/               # Gradle wrapper jar and properties
├── src/
│   ├── main/
│   │   ├── kotlin/com/clinicapets/
│   │   │   ├── Main.kt           # Main entry point with demo
│   │   │   ├── model/
│   │   │   │   └── Models.kt     # Domain models (Pet, Owner, Veterinarian, etc.)
│   │   │   └── service/
│   │   │       └── ClinicService.kt # Business logic
│   │   └── resources/
│   └── test/
│       ├── kotlin/com/clinicapets/
│       │   └── ClinicServiceTest.kt # Unit tests
│       └── resources/
└── README.md
```

## 🛠️ How to Run

### Run the application
```bash
# On Windows PowerShell / Command Prompt:
.\gradlew.bat run

# On Linux / macOS:
./gradlew run
```

### Run tests
```bash
# On Windows:
.\gradlew.bat test

# On Linux / macOS:
./gradlew test
```

### Build project
```bash
.\gradlew.bat build
```

## 💻 Opening in IntelliJ IDEA

1. Open **IntelliJ IDEA**.
2. Select **File -> Open...** and select this directory (`clinicaPets`).
3. IntelliJ IDEA will automatically recognize the Gradle project and configure the dependencies and JDK.
