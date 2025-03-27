============================================
# Expense Tracker - Personal Finance Management
============================================

A full-stack expense tracking application built with:
- Java 17
- Spring Boot 3.2.x
- MySQL
- Thymeleaf
- Bootstrap 5
- Chart.js

## FEATURES
--------
- User authentication (login/registration)
- Expense management (CRUD operations)
- Expense categorization
- Real-time expense reports and charts
- Monthly expense tracking
- Responsive web interface

## PREREQUISITES
-------------
1. Java 17 JDK
2. Maven 3.8+
3. MySQL 8.0+
4. IDE (IntelliJ, Eclipse, or VS Code)

## SETUP INSTRUCTIONS
------------------
1. Database Setup:
   - Create MySQL database:
     CREATE DATABASE expense_tracker;
   - Update application.properties with your credentials:
     spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
     spring.datasource.username=your_username
     spring.datasource.password=your_password

2. Build and Run:
   - Using Maven:
     mvn clean install
     mvn spring-boot:run
   - Using IDE:
     Import as Maven project and run ExpenseTrackerApplication

3. Access Application:
   - http://localhost:8080
   - Register a new user or use default admin credentials (if configured)

## PROJECT STRUCTURE
----------------
src/
├── main/
│   ├── java/
│   │   └── com/example/expensetracker/
│   │       ├── config/          # Configuration classes
│   │       ├── controller/      # MVC Controllers
│   │       ├── model/           # Entity classes
│   │       ├── repository/      # JPA Repositories
│   │       ├── service/         # Business logic
│   │       └── ExpenseTrackerApplication.java
│   ├── resources/
│   │   ├── static/             # CSS/JS/Images
│   │   │   ├── css/
│   │   │   └── js/
│   │   ├── templates/          # Thymeleaf HTML
│   │   │   ├── auth/           # Login/Register
│   │   │   ├── expenses/       # Expense views
│   │   │   ├── categories/     # Category views
│   │   │   └── layout.html     # Main template
│   │   └── application.properties
│   └── webapp/
└── test/                       # Test classes

## API ENDPOINTS
------------
- GET    /api/expenses          - List all expenses
- POST   /api/expenses          - Create new expense
- GET    /api/expenses/{id}     - Get expense by ID
- PUT    /api/expenses/{id}     - Update expense
- DELETE /api/expenses/{id}     - Delete expense
- GET    /api/categories        - List all categories
- POST   /api/categories        - Create new category

## TECHNOLOGIES USED
-----------------
- Backend:
  - Spring Boot 3.2
  - Spring Security
  - Spring Data JPA
  - Hibernate
  - Lombok

- Frontend:
  - Thymeleaf
  - Bootstrap 5
  - Chart.js
  - jQuery

- Database:
  - MySQL 8.0

- Build Tool:
  - Maven

## CONFIGURATION
------------
Key application.properties settings:
- Server port: server.port=8080
- Thymeleaf cache: spring.thymeleaf.cache=false (dev)
- Hibernate ddl-auto: spring.jpa.hibernate.ddl-auto=update

## TROUBLESHOOTING
--------------
1. Database connection issues:
   - Verify MySQL is running
   - Check credentials in application.properties

2. Template errors:
   - Clean and rebuild project
   - Check thymeleaf template locations

3. Dependency issues:
   - Run 'mvn clean install'
   - Check for version conflicts

## CONTRIBUTING
------------
1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## LICENSE
-------
MIT License - See LICENSE file for details

## CONTACT
-------
For support or questions:
- Email: your.email@example.com
- GitHub: github.com/yourusername
