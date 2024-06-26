# Product-Catalogue-Management

_**Overview:**_

This is a Product Catalogue Management Application. The Product Catalogue Management application is a structured product catalogue system built using Spring Boot. It provides functionalities to manage products, including adding, updating, deleting, and searching for products.

_**Features:**_

**1. Add Product:** Add new products to the catalogue with details such as name, description, price, categories, and attributes.

**2. Update Product:** Update existing product details, including name, description, price, categories, and attributes.

**3. Delete Product:** Remove products from the catalogue.

**4. Search Products:** Search for products based on various criteria such as name, categories, and attributes.

_**Components:**_ 

**1. ProductController:**

The 'ProductController class' located in the "product.controller package" handles HTTP requests related to product management including adding, updating, deleting, and searching for products. The ProductController class in the product.controller package handles HTTP requests related to product management within the Product Catalogue Management Application.

_**Endpoints:**_

**1. Add Product:**

**Endpoint:** 'POST /api/products/addProduct'

**Description:** Adds a new product to the catalogue.

**Request Body:** Product object.

**Response:** Added product object.

**2. Get All Products:**

**Endpoint:** 'GET /api/products/getAllProducts'

**Description:** Retrieves a paginated list of all products from the catalogue.

**Query Parameters:**
page (optional, default: 0): Page number.

size (optional, default: 10): Number of items per page.

sortBy (optional, default: "name"): Field to sort by.

**Response:** Paginated list of product objects.

**3. Get Product by ID:**

**Endpoint:** 'GET /api/products/getProductById/{id}'

**Description:** Retrieves a product by its ID.

**Path Variable:** Product ID.

**Response:** Product object with the specified ID.

**4. Update Product:**

**Endpoint:** 'PUT /api/products/updateProduct/{id}'

**Description:** Updates an existing product.

**Path Variable:** Product ID.

**Request Body:** Updated product object.

**Response:** Updated product object.

**5. Delete Product:**

**Endpoint:** 'DELETE /api/products/deleteProduct/{id}'

**Description:** Deletes an existing product.

**Path Variable:** Product ID.

**6. Search Products:**

**Endpoint:** 'GET /api/products/searchProducts'

**Description:** Searches for products based on various criteria such as name, categories, and attributes.

**Query Parameters:** Can include name, categories, and attributes.

**Response:** List of product objects matching the search criteria.

**2. ProductRepository:**

The ProductRepository interface provides methods to interact with the MongoDB database for CRUD operations on products.

**3. Product Entity:**

The Product class represents a product entity with attributes such as ID, name, description, price, categories, and attributes.

**4. Rating Entity:**

The Rating class represents a rating entity with attributes such as user ID, rating value, and comments.

**5. Availability Entity:**

The Availability class represents the availability of a product with attributes indicating whether the product is in stock and its quantity.

_**Dependencies:**_

**1. Spring Boot Starter Data MongoDB:** Provides support for MongoDB database integration.

**2. Spring Boot Starter Web:** Enables building web applications using Spring MVC.

**3. Springdoc OpenAPI Starter Web MVC UI:** Generates API documentation using OpenAPI.

_**Configuration:**_

The application is configured to connect to a MongoDB database hosted locally. The MongoDB host is set to localhost with the default port 27019, and the database name is productdb.

_**Setting up the MongoDB Database:**_

**1. Install MongoDB:** If you haven't already installed MongoDB, download and install it from the official MongoDB website (MongoDB Download).

**2. Start MongoDB Server:** Start the MongoDB server by running the following command in your terminal or command prompt: mongod
Above command will start the MongoDB server locally on the default port (27017), but our port is 27019.

**3. Access MongoDB Shell:** Open a new terminal or command prompt window and access the MongoDB shell by running the following command:mongosh or mongo
This will open the MongoDB shell, where you can interact with the MongoDB database.

**4. Create Database:** Create a new database named productdb by running the following command in the MongoDB shell: use productdb
This command switches to the productdb database. If the database doesn't exist, MongoDB will create it.


_**Seeding the Database with Initial Data:**_

**1. Insert Initial Data:** Use the MongoDB shell or a script to insert some initial data into the products collection. Here's an example of how you can insert a sample product document into the products collection:

**_Example_:**

db.products.insertOne(
      {
        "name": "Product Name",
        "description": "Product Description",
        "price": 99.99,
        "categories": ["Category1", "Category2"],
        "attributes":
        {
          "attribute1": "value1",
          "attribute2": "value2"
        }
      }
);

**2. Verify Data:** After inserting the initial data, you can verify that it has been successfully added to the database by querying the products collection: db.products.find()

**3. Additional Seeding:** Repeat the insertion process for any additional initial data you want to seed into the database.

**Configuration Update:**

Update the MongoDB configuration in your application properties or YAML file to connect to the newly created productdb database. Here's an example of how you can configure the connection:

**_Example_:**

spring.data.mongodb.host=localhost

spring.data.mongodb.port=27019

spring.data.mongodb.database=productdb

**Swagger:**

Swagger is a helpful tool for documenting your API (Application Programming Interface). Think of it like a manual that explains how to use your API. With Swagger, you can describe all the endpoints in your API, what kind of data they expect, and what they'll return. This makes it easier for other developers (or even yourself in the future) to understand and use your API.

**Swagger UI:**

Swagger UI is a web interface that automatically generates documentation for your API based on the information you provide. It's like having a website that shows all the details of your API in an easy-to-read format. With Swagger UI, developers can see all the endpoints, what data they need to send, and what they'll get back. They can even try out the endpoints right there in their web browser.

**How to Use Swagger:**

For the integration between spring-boot and swagger-ui, add the library to the list of your project dependencies (No additional configuration is needed) which is given below.

<dependency>
      
      <groupId>org.springdoc</groupId>
      
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      
      <version>2.5.0</version>
      
</dependency>

**Swagger Integration:**

above dependancy will automatically deploy swagger-ui to a spring-boot application:

Documentation will be available in HTML format, using the official "swagger-ui jars"

The Swagger UI page will then be available at "http://server:port/context-path/swagger-ui.html" and the OpenAPI description will be available at the following url for json format: "http://server:port/context-path/v3/api-docs"

Swagger UI can be accessed at `http://localhost:27019/swagger-ui.html`.

**JSON representation of the Product entity:**

{
    "id": "1",
    "name": "Product Name",
    "description": "Product Description",
    "price": 99.99,
    "categories": ["Category1", "Category2"],
    "attributes":
    {
      "attribute1": "value1",
      "attribute2": "value2"
    }
}

**This JSON represents a single product with the following attributes:**

This JSON structure corresponds to the fields defined in the Product class. Each instance of the Product entity in your application would have similar attributes with corresponding values.

**id:** A unique identifier for the product.

**name:** The name of the product.

**description:** A description of the product.

**price:** The price of the product.

**categories**: An array of categories to which the product belongs.

**attributes:** Additional attributes of the product, stored as key-value pairs.
