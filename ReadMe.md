# POSTMAN LINK: https://www.getpostman.com/collections/bfdcf69adbe82eafd096

# Consumer-Service
## 1. GetAllUsers
```
          Method: GET
          
          Endpoint: http://localhost:8084/consumer/auth/get-users
          
```

## 2. Registration
```
          Method: POST
          
          Endpoint: http://localhost:8084/consumer/auth/signUp
          
          Payload: {
                        "username":"{{authenticate_username}}",
                        "password":"{{authenticate_password}}",
                        "confirm password":"{{authenticate_confirmPassword}}",
                        "email":"{{authenticate_email}}"
                    }
```

## 3. Login
```
          Method: POST
          
          Endpoint: http://localhost:8084/consumer/auth/login
          
          Payload: {
                        "username":"{{authenticate_username}}",
                        "password":"{{authenticate_password}}"
                    }
```

# JWT-SERVICE
## 1. Create Token
```
          Method: GET (Required JWT Token)
          
          Endpoint: http://localhost:8084/consumer/getToken/{id}
          
```

## 2. Get User ID From Token
```
          Method: GET (Required JWT Token)
          
          Endpoint: http://localhost:8081/consumer/getUserId/{token}
          
```

# SHOP-SERVICE
## 1. Get All Products
```
          Method: GET
          
          Endpoint: http://localhost:8084/consumer/public/product/getAllProduct
          
```

## 2. Get All Categories
```
          Method: GET
          
          Endpoint: http://localhost:8084/consumer/public/category/getAllCategory
          
```

## 3. Get Product By Any Field
```
          Method: POST
          
          Endpoint: http://localhost:8084/consumer/public/product/getProductByField
          
          Payload: {
                        "id": 2,
                        "name": "paneer",
                        "price": "120",
                        "description": "full"
                    }
```

## 4. Get Category By Any Field
```
          Method: POST
          
          Endpoint: http://localhost:8084/consumer/public/product/getCategoryByField
          
          Payload: {
                        "id": 2,
                        "type":"food"
                    }
```

## 5. Add Category
```
          Method: POST (Token Required)
          
          Endpoint: http://localhost:8084/consumer/category/addCategory
          
          Payload: {
                        "id": 2,
                        "type":"food"
                    }
```

## 6. Update Category
```
          Method: POST (Token Required)
          
          Endpoint: http://localhost:8084/consumer/category/updateCategory
          
          Payload: {
                        "id": 2,
                        "type":"fooddy"
                    }
```

## 7. Delete Category
```
          Method: DELETE (Token Required)
          
          Endpoint: http://localhost:8084/consumer/category/deleteCategory/{id}
          
```

## 8. Add Product
```
          Method: POST (Token Required)
          
          Endpoint: http://localhost:8084/consumer/product/addProduct
          
          Payload: {
                        "name":"paneer",
                        "price":"100",
                        "description":"full"
                    }
```

## 9. Update Product
```
          Method: POST (Token Required)
          
          Endpoint: http://localhost:8084/consumer/product/updateProduct
          
          Payload: {
                        "id":1,
                        "name":"paneer",
                        "price":"120",
                        "description":"full"
                    }
```

## 10. Delete Product
```
          Method: GET (Token Required)
          
          Endpoint: http://localhost:8084/consumer/product/deleteProduct/{id}
          
```

## 11. Connect Product with Category (MANY-TO-MANY)
```
          Method: GET (Token Required)
          
          Endpoint: http://localhost:8084/consumer/product/{pid}-with-{cid}
          
```










