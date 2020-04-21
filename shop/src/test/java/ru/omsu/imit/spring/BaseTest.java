package ru.omsu.imit.spring;

import com.google.gson.Gson;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.utils.MyBatisUtils;
import ru.omsu.imit.utils.spring.ConfigUtils;

public class BaseTest {
    protected RestTemplate template = new RestTemplate();
    protected static String urlPrefix;
    protected Gson json = new Gson();
    private static boolean setUpIsDone = false;

    @BeforeClass()
    public static void setUp() {

            Assume.assumeTrue(MyBatisUtils.initSqlSessionFactory());

    }

    @BeforeClass
    public static void before() {
        new ConfigUtils("config.properties");
        urlPrefix = String.format("http://localhost:%d", ConfigUtils.getRestHttpPort());
    }

    /*@Before
    public void deleteAll(){
        template.exchange(urlPrefix + "/api/debug/clear", HttpMethod.POST, null, String.class);
    }*/


    protected String createBuyer(BuyerRequest dto) {
        HttpEntity<BuyerRequest> request = new HttpEntity<>(dto);
        HttpEntity<String> response = template.exchange(urlPrefix + "/api/buyer", HttpMethod.POST, request, String.class);
        HttpHeaders headers = response.getHeaders();

        return headers.getFirst(headers.SET_COOKIE);
    }
}
