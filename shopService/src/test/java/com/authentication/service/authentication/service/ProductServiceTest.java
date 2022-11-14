package com.authentication.service.authentication.service;

import com.authentication.service.authentication.Entity.Category;
import com.authentication.service.authentication.Entity.Product;
import com.authentication.service.authentication.Repository.CatergoryRepository;
import com.authentication.service.authentication.Repository.ProductJDBC;
import com.authentication.service.authentication.Repository.ProductRepository;
import com.authentication.service.authentication.Repository.ProductRepository;
import com.authentication.service.authentication.Service.CategoryService;
import com.authentication.service.authentication.Service.ProductService;
import com.authentication.service.authentication.exceptionHandling.CategoryException;
import com.authentication.service.authentication.exceptionHandling.ProductException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductJDBC jdbc;





    @InjectMocks
    private ProductService service;

    @Before // Before Each Test Case, ready the mocked data
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public  void getAllProduct(){
        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product(1,"name","price","description"));
        productList.add(new Product(2,"name","price","description"));
        productList.add(new Product(3,"name","price","description"));

        when(repository.findAll()).thenReturn(productList);

        List<Product> movieResult = service.getAllProduct();

        assertEquals(3,movieResult.size());
    }

    @Test
    public  void getProductByField() throws CategoryException, ProductException {
        Product product = new Product(1,"name","price","description");


        when(jdbc.getProductByName("name")).thenReturn(product);

        Product product1 = service.getProductByField(new Product(0,"name",null,null));

        assertEquals(product1.getId(),product.getId());
        assertEquals(product1.getName(),product.getName());
        assertEquals(product1.getDescription(),product.getDescription());
        assertEquals(product1.getPrice(),product.getPrice());
    }


    @Test
    public  void saveProduct() throws CategoryException, ProductException {

        Product product = new Product(1,"name","price","description");


        when(repository.save(product)).thenReturn(product);

        Product product1 = service.addProduct(product);

        assertEquals(product1.getId(),product.getId());
        assertEquals(product1.getName(),product.getName());
        assertEquals(product1.getDescription(),product.getDescription());
        assertEquals(product1.getPrice(),product.getPrice());

    }


    @Test
    public  void updateProduct() throws  ProductException {

        Product product = new Product(1,"name","price","description");


        when(repository.save(product)).thenReturn(product);
        when(repository.findById(product.getId())).thenReturn(Optional.of(product));


        Product product1 = service.updateProduct(product);

        assertEquals(product1.getId(),product.getId());
        assertEquals(product1.getName(),product.getName());
        assertEquals(product1.getDescription(),product.getDescription());
        assertEquals(product1.getPrice(),product.getPrice());

    }
    @Test
    public  void deleteCategory() throws CategoryException, ProductException {
//        repository.findById(Id);
//        repository.deleteById(Id);
//        return "{\"message\":\"Successfully Deleted!\"}";
        Product product = new Product(1,"name","price","description");

        when(repository.findById(product.getId())).thenReturn(Optional.of(product));
        service.deleteProduct(product.getId());
        verify(repository, times(1)).deleteById(product.getId());

    }
}
