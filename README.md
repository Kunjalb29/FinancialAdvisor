# FinancialAdvisor

A Spring Boot application that models a financial advisory system using the Java Persistence API (JPA).

## Data Model

```
FinancialAdvisor (1) ──── (N) Client (1) ──── (1) Portfolio (1) ──── (N) Security
```

| Entity | Primary Key | Description |
|---|---|---|
| `FinancialAdvisor` | `advisor_id` | An advisor managing multiple clients |
| `Client` | `client_id` | A client assigned to one advisor, with one portfolio |
| `Portfolio` | `portfolio_id` | A client's investment portfolio |
| `Security` | `security_id` | An individual security (stock/bond/etc.) held in a portfolio |

## Tech Stack

- **Java 17**
- **Spring Boot 3.2**
- **Spring Data JPA** (Hibernate)
- **H2** in-memory database (dev/testing)
- **Maven**

## Getting Started

### Prerequisites
- Java 17+
- Maven (or use the included `mvnw` wrapper)
- IntelliJ IDEA (recommended)

### Run the Application

**Via IntelliJ:** Open the project and run `FinancialAdvisorApplication.java`.

**Via terminal:**
```bash
./mvnw spring-boot:run        # macOS/Linux
mvnw.cmd spring-boot:run      # Windows
```

The app starts on **http://localhost:8080**.

### H2 Console

Access the in-memory database at **http://localhost:8080/h2-console**:

| Setting | Value |
|---|---|
| JDBC URL | `jdbc:h2:mem:testdb` |
| Username | `sa` |
| Password | *(leave blank)* |

Tables auto-created on startup: `FINANCIAL_ADVISOR`, `CLIENT`, `PORTFOLIO`, `SECURITY`.

## Project Structure

```
src/
└── main/
    ├── java/com/financialadvisor/
    │   ├── FinancialAdvisorApplication.java
    │   └── entities/
    │       ├── FinancialAdvisor.java
    │       ├── Client.java
    │       ├── Portfolio.java
    │       └── Security.java
    └── resources/
        └── application.properties
```
