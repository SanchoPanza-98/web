package ru.omsu.imit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import ru.omsu.imit.dto.request.ProductRequest;
import ru.omsu.imit.dto.response.ProductResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductSpringTest extends BaseTest {



    @Test
    public void testCreateProduct() {
        ProductRequest dto = new ProductRequest(1,12500, "Tea");
        HttpEntity<ProductRequest> request = new HttpEntity<>(dto);

        HttpEntity<String> response = template.exchange(urlPrefix + "/api/product", HttpMethod.POST, request, String.class);

        //ResponseEntity<ProductResponse> res = template.postForEntity(new URI(""+urlPrefix+"/api/product"),dto,ProductResponse.class);
        ProductResponse dtoResponse = json.fromJson(response.getBody(),ProductResponse.class);
        assert dtoResponse != null;
        assertEquals(dto.getProductName(), dtoResponse.getProductName());


    }

    @Test
    public void testUpdateProduct() {
        ProductRequest dto = new ProductRequest(1,50, "Computer");
        HttpEntity<ProductRequest> request = new HttpEntity<>(dto);

        HttpEntity<String> response = template.exchange(urlPrefix + "/productUp/"+1, HttpMethod.PUT, request, String.class);

        //ResponseEntity<ProductResponse> res = template.postForEntity(new URI(""+urlPrefix+"/api/product"),dto,ProductResponse.class);
        ProductResponse dtoResponse = json.fromJson(response.getBody(),ProductResponse.class);
        System.out.println(dtoResponse);
        assert dtoResponse != null;
        assertEquals(dto.getProductName(), dtoResponse.getProductName());


    }

    @Test
    public void testGetProductById() {
        ProductRequest dto = new ProductRequest(1,12500, "Tea");
        HttpEntity<String > request = new HttpEntity<>("2");

        HttpEntity<String> response = template.exchange(urlPrefix + "/api/product/"+2+"", HttpMethod.GET, request, String.class);

        //ResponseEntity<ProductResponse> res = template.postForEntity(new URI(""+urlPrefix+"/api/product"),dto,ProductResponse.class);
        ProductResponse dtoResponse = json.fromJson(response.getBody(),ProductResponse.class);
        assert dtoResponse != null;
        assertEquals(dto.getProductName(), dtoResponse.getProductName());
        assertEquals(dto.getCost(),dtoResponse.getCost());

    }

    @Test
    public void testGetProductsByName() {
        ProductRequest dto = new ProductRequest(1,15000, "Tea");
        HttpEntity<ProductRequest> request = new HttpEntity<>(dto);

        HttpEntity<String> response = template.exchange(urlPrefix + "/api/product", HttpMethod.POST, request, String.class);

        //ResponseEntity<ProductResponse> res = template.postForEntity(new URI(""+urlPrefix+"/api/product"),dto,ProductResponse.class);
        ProductResponse dtoResponse = json.fromJson(response.getBody(),ProductResponse.class);
        assert dtoResponse != null;
        assertEquals(dto.getProductName(), dtoResponse.getProductName());
        assertEquals(dto.getCost(),dtoResponse.getCost());


        HttpEntity<String> responseGet = template.exchange(urlPrefix+"api/products/"+"Tea",HttpMethod.GET,request,String.class);
        System.out.println(responseGet);
    }
}
