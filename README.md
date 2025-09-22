# CCRM - Customer Relationship Management System

A comprehensive Customer Relationship Management (CRM) system built with Java, designed to help businesses manage their customer interactions, track sales, and improve customer relationships.

## Project Overview

CCRM is a modern, scalable customer relationship management system that provides businesses with the tools they need to:

- Manage customer information and profiles
- Track customer interactions and communications
- Monitor sales opportunities and pipeline
- Generate reports and analytics
- Maintain contact history and follow-ups

## Features

### Week 1 Implementation
- ✅ **Project Scaffolding**: Complete Maven project structure
- ✅ **Domain Model**: Core customer and contact entities
- ✅ **Configuration Management**: Centralized application configuration
- ✅ **Application Bootstrap**: Main application entry point

### Planned Features
- Customer management (CRUD operations)
- Contact tracking and history
- Sales pipeline management
- Reporting and analytics
- User authentication and authorization
- REST API endpoints
- Web-based user interface

## Technology Stack

- **Java 17**: Core programming language
- **Maven**: Build and dependency management
- **JUnit 5**: Testing framework
- **Jackson**: JSON processing
- **H2 Database**: In-memory database for development

## Project Structure

```
ccrm/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/ccrm/
│   │   │       ├── config/          # Configuration classes
│   │   │       │   └── AppConfig.java
│   │   │       ├── model/           # Domain models
│   │   │       │   ├── Customer.java
│   │   │       │   ├── CustomerStatus.java
│   │   │       │   ├── Contact.java
│   │   │       │   └── ContactType.java
│   │   │       ├── service/         # Business logic layer
│   │   │       ├── repository/      # Data access layer
│   │   │       └── CcrmApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/ccrm/
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8 or higher

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/raksha24bce11472-sys/ccrm.git
   cd ccrm
   ```

2. Build the project:
   ```bash
   mvn clean compile
   ```

3. Run tests:
   ```bash
   mvn test
   ```

4. Run the application:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.ccrm.CcrmApplication"
   ```

### Development Setup

1. Import the project into your IDE as a Maven project
2. Ensure Java 17 is configured as the project SDK
3. Run `mvn clean install` to download dependencies
4. Run the main class `CcrmApplication` to verify setup

## Configuration

Application settings can be configured in `src/main/resources/application.properties`:

```properties
# Application Information
app.name=CCRM - Customer Relationship Management
app.version=1.0.0

# Database Configuration
database.url=jdbc:h2:mem:ccrm
database.driver=org.h2.Driver

# Application Settings
max.customers.per.page=50
contact.reminder.days=7
```

## Domain Model

### Customer
Represents a customer in the CRM system with the following properties:
- Personal information (name, email, phone)
- Company affiliation
- Customer status (Active, Inactive, Prospect, Lead, Suspended)
- Audit timestamps

### Contact
Represents an interaction with a customer:
- Contact type (Phone Call, Email, Meeting, etc.)
- Subject and notes
- Contact date and person responsible
- Link to customer record

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## Development Roadmap

### Week 1: Foundation ✅
- [x] Project scaffolding and structure
- [x] Domain model implementation
- [x] Configuration management
- [x] Basic application setup

### Week 2: Data Layer (Planned)
- [ ] Repository pattern implementation
- [ ] Database integration
- [ ] Data persistence layer
- [ ] Unit tests for data layer

### Week 3: Business Logic (Planned)
- [ ] Service layer implementation
- [ ] Business logic and validation
- [ ] Customer management operations
- [ ] Contact tracking functionality

### Week 4: API Layer (Planned)
- [ ] REST API endpoints
- [ ] Request/response handling
- [ ] API documentation
- [ ] Integration tests

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Project maintainer: [Your Name]
Project Link: [https://github.com/raksha24bce11472-sys/ccrm](https://github.com/raksha24bce11472-sys/ccrm)
