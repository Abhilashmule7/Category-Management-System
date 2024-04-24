# Product-Catalogue-Management
**Overview**
This is a Product Catalogue Management Application. The Product Catalogue Management application is a structured product catalogue system built using Spring Boot. It provides functionalities to manage products, including adding, updating, deleting, and searching for products.

**Features**
Add Product: Add new products to the catalogue with details such as name, description, price, categories, and attributes.
Update Product: Update existing product details, including name, description, price, categories, and attributes.
Delete Product: Remove products from the catalogue.
Search Products: Search for products based on various criteria such as name, categories, and attributes.

**Components**

**1. ProductController**
The ProductController class handles HTTP requests related to product management, including adding, updating, deleting, and searching for products.

**2. ProductRepository**
The ProductRepository interface provides methods to interact with the MongoDB database for CRUD operations on products.

**3. Product Entity**
The Product class represents a product entity with attributes such as ID, name, description, price, categories, and attributes.

**4. Rating Entity**
The Rating class represents a rating entity with attributes such as user ID, rating value, and comments.

**5. Availability Entity**
The Availability class represents the availability of a product with attributes indicating whether the product is in stock and its quantity.

**Dependencies**
Spring Boot Starter Data MongoDB: Provides support for MongoDB database integration.
Spring Boot Starter Web: Enables building web applications using Spring MVC.
Springdoc OpenAPI Starter Web MVC UI: Generates API documentation using OpenAPI.

**Configuration**
The application is configured to connect to a MongoDB database hosted locally. The MongoDB host is set to localhost with the default port 27019, and the database name is productdb.

**Swagger Integration**
This application utilizes Swagger for API documentation. Swagger UI can be accessed at `http://localhost:27019/swagger-ui.html`.
