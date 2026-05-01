<div align="center">
  <h1>☕ Java Project Portfolio</h1>
  <p><em>A diverse suite of Java applications exploring OOP, Socket Programming, and System Design.</em></p>
</div>

---

## 📖 Short Description
This repository contains a wide array of Java-based projects ranging from terminal-based RPGs and algorithms to more complex architectural undertakings like a Ride-Sharing Manager and a full-fledged Bookstore Manager. It is a testament to mastering Object-Oriented Programming principles and exploring Java's rich standard library.

## 🏗️ Architecture Details
Due to the diverse nature of the repository, the architecture varies by project:
- **Client-Server Projects:** Applications like `JavaSockets`, `TransportManager`, and `Twitter` utilize Java's `java.net` package to establish robust client-server communication using TCP/UDP protocols.
- **Management Systems:** Projects like `BookStoreManager` and `rideSharingManager` follow a clear separation of concerns, utilizing Controller-Service-Repository patterns to separate business logic from data access and user interface.
- **Design Patterns:** Heavy implementation of classic Gang of Four (GoF) patterns, including Singleton, Factory, and Observer patterns, ensuring code reusability and scalability.

## 💻 Tech Stack
- **Language:** Java (JDK 8+)
- **Concepts:** Object-Oriented Programming (OOP), Multithreading, Socket Programming, File I/O
- **Tools:** Gradle/Maven (if applicable), standard `javac` compiler

## 🚀 Local Setup Guide

1. **Verify Java Installation:**
   Make sure you have the Java Development Kit (JDK) installed.
   ```bash
   java -version
   ```

2. **Clone and Navigate:**
   ```bash
   git clone <repository-url>
   cd JavaProgramming
   ```

3. **Choose a Sub-project:**
   Navigate into the specific project you wish to run.
   ```bash
   cd BookStoreManager
   ```

4. **Compile and Run:**
   If using an IDE like IntelliJ IDEA or Eclipse, simply import the folder as a project. For command line:
   ```bash
   javac *.java
   java Main
   ```
   *(Note: Replace `Main` with the actual entry point class name of the project.)*
