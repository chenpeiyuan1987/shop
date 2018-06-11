package org.yuan.demo.shop.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.yuan.demo.shop.entity.external.Result;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserControllerTest {

    @Test
    public void testSignInSuccess() throws Exception {
        String username = "chen";
        String password = "1234";
        String path = "http://localhost:8080/user/signIn";
        String query = String.format("?username=%s&password=%s", username, password);
        HttpGet request = new HttpGet(path + query);
        
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        response.close();
        client.close();
        
        ObjectMapper mapper = new ObjectMapper();
        Result result = mapper.readValue(json, Result.class);
        
        Assert.assertEquals(result.getCode().intValue(), 0);
    }
    
    @Test(dataProvider="provideSignInUsers")
    public void testSignInFailure(String username, String password, int expect) throws Exception {
        String path = "http://localhost:8080/user/signIn";
        String query = String.format("?username=%s&password=%s", username, password);
        HttpGet request = new HttpGet(path + query);
        
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        response.close();
        client.close();
        
        ObjectMapper mapper = new ObjectMapper();
        Result result = mapper.readValue(json, Result.class);
        
        Assert.assertEquals(result.getCode().intValue(), expect);
    }
    
    @DataProvider
    private Object[][] provideSignInUsers() {
        return new Object[][]{
            {"",        "",     1},
            {"chen",    "",     1},
            {"",        "1234", 1},
            {"yuan",    "1234", 1},
            {"chen",    "123",  1},
        };
    }
}
