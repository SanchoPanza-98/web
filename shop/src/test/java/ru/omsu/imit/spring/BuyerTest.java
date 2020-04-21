package ru.omsu.imit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;
import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.dto.response.BuyerResponse;
import ru.omsu.imit.Server;
import ru.omsu.imit.dto.response.ListSelectedProductsPurchaseResponse;
import ru.omsu.imit.dto.response.ListSelectedProductsResponse;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInBasketResponse;

import java.sql.Date;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BuyerTest extends BaseTest {
        @Test
    public void testCreateBuyer() {
        BuyerRequest dto = new BuyerRequest(1,"Иванов", "Иван", "Иванович",
                Date.valueOf("1980-02-13"), "ivanov2@mail.ru","ivanov","0000", "00000000013");


        HttpEntity<BuyerRequest> request = new HttpEntity<>(dto);
        HttpEntity<String> response = template.exchange(urlPrefix + "/api/buyer", POST, request, String.class);
        HttpHeaders headers = response.getHeaders();

            /*String set_cookie = headers.getFirst(HttpHeaders.SET_COOKIE);
            assertNotNull(set_cookie);*/

        BuyerResponse dtoResponse = json.fromJson(response.getBody(), BuyerResponse.class);
        assert dtoResponse != null;
        assertEquals(dto.getFirstName(), dtoResponse.getFirstName());
        assertEquals(dto.getSecondName(), dtoResponse.getSecondName());
        assertEquals(dto.getPatronymic(), dtoResponse.getPatronymic());
        assertEquals(dto.getTelephoneNum(), dtoResponse.getEmail());
        assertEquals(dto.getEmail(), dtoResponse.getTelephoneNum());

    }

    @Test
    public void testGetBuyerId() {
        BuyerRequest dto = new BuyerRequest(1,"Иванов", "Иван", "Иванович",
                Date.valueOf("1980-02-13"), "ivanov2@mail.ru","ivanov","0000", "00000000013");

        HttpEntity<String> request = new HttpEntity<>("1");

        HttpEntity<String> response = template.exchange(urlPrefix+ "/api/buyer/"+1+"",
                HttpMethod.GET,request, String.class);
        HttpHeaders headers = response.getHeaders();
            /*String set_cookie = headers.getFirst(HttpHeaders.SET_COOKIE);
            assertNotNull(set_cookie);*/

        BuyerResponse dtoResponse = json.fromJson(response.getBody(), BuyerResponse.class);
        System.out.println(""+dtoResponse.toString());
        assert dtoResponse != null;
        assertEquals(dto.getFirstName(), dtoResponse.getFirstName());
        assertEquals(dto.getSecondName(), dtoResponse.getSecondName());
        assertEquals(dto.getPatronymic(), dtoResponse.getPatronymic());
        assertEquals(dto.getTelephoneNum(), dtoResponse.getEmail());
       // assertEquals(dto.getEmail(), dtoResponse.getTelephoneNum());
    }

    @Test
    public void testBuyerUpdate() {
        BuyerRequest dto = new BuyerRequest(1,"Петров", "Сидор", "Иванович",
                Date.valueOf("1980-02-13"), "ivanov2@mail.ru","ivanov","0000" ,"00000000013");

        HttpEntity<BuyerRequest> request = new HttpEntity<>(dto);
        HttpEntity<String> response = template.exchange(urlPrefix + "/api/buyer/"+1, PUT, request, String.class);
        HttpHeaders headers = response.getHeaders();
            /*String set_cookie = headers.getFirst(HttpHeaders.SET_COOKIE);
            assertNotNull(set_cookie);*/

        BuyerResponse dtoResponse = json.fromJson(response.getBody(), BuyerResponse.class);
        assert dtoResponse != null;
        assertEquals(dto.getFirstName(), dtoResponse.getFirstName());
        assertEquals(dto.getSecondName(), dtoResponse.getSecondName());
        assertEquals(dto.getPatronymic(), dtoResponse.getPatronymic());
        //assertEquals(dto.getTelephoneNum(), dtoResponse.getEmail());
        //assertEquals(dto.getEmail(), dtoResponse.getTelephoneNum());

    }

    @Test
    public void testGetAllPurchasesByBuyerId() {
        BuyerRequest dto = new BuyerRequest(1,"Иванов", "Иван", "Иванович",
                Date.valueOf("1980-02-13"), "ivanov1@mail.ru", "ivanov","00000","00000000012");

        HttpEntity<String> request = new HttpEntity<>("4");

        HttpEntity<String> response = template.exchange(urlPrefix+ "/api/buyer/"+1+"/purchase",
                HttpMethod.GET,request, String.class);
        HttpHeaders headers = response.getHeaders();
            /*String set_cookie = headers.getFirst(HttpHeaders.SET_COOKIE);
            assertNotNull(set_cookie);*/
        ListSelectedProductsPurchaseResponse dtoResponse = json.fromJson(response.getBody()
                , ListSelectedProductsPurchaseResponse.class);
        System.out.println(""+dtoResponse.toString());
        /*assert dtoResponse != null;
        assertEquals(dto.getFirstName(), dtoResponse.getFirstName());
        assertEquals(dto.getSecondName(), dtoResponse.getSecondName());
        assertEquals(dto.getPatronymic(), dtoResponse.getPatronymic());
        assertEquals(dto.getTelephoneNum(), dtoResponse.getEmail());
        // assertEquals(dto.getEmail(), dtoResponse.getTelephoneNum());*/
    }

    @Test
    public void testGetBasketByBuyerId() {
        BuyerRequest dto = new BuyerRequest(1,"Иванов", "Иван", "Иванович",
                Date.valueOf("1980-02-13"), "ivanov1@mail.ru","ivanov","0000", "00000000012");

        HttpEntity<String> request = new HttpEntity<>("4");

        HttpEntity<String> response = template.exchange(urlPrefix+ "/api/buyer/"+1+"/basket",
                HttpMethod.GET,request, String.class);
        HttpHeaders headers = response.getHeaders();
            /*String set_cookie = headers.getFirst(HttpHeaders.SET_COOKIE);
            assertNotNull(set_cookie);*/
        ListSelectedProductsResponse dtoResponse = json.fromJson(response.getBody()
                , ListSelectedProductsResponse.class);
        System.out.println(""+dtoResponse.toString());
        /*assert dtoResponse != null;
        assertEquals(dto.getFirstName(), dtoResponse.getFirstName());
        assertEquals(dto.getSecondName(), dtoResponse.getSecondName());
        assertEquals(dto.getPatronymic(), dtoResponse.getPatronymic());
        assertEquals(dto.getTelephoneNum(), dtoResponse.getEmail());
        // assertEquals(dto.getEmail(), dtoResponse.getTelephoneNum());*/
    }

}
