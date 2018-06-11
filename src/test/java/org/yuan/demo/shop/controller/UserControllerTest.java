package org.yuan.demo.shop.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
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
        HttpGet request = new HttpGet(getSignInUrl("chen", "1234"));
        Result result = result(request);
        
        Assert.assertEquals(result.getCode().intValue(), 0);
    }
    
    @Test
    public void testSignUpSuccess() throws Exception {
        HttpGet request = new HttpGet(getSignUpUrl("yuan", "1234"));
        Result result = result(request);
        
        Assert.assertEquals(result.getCode().intValue(), 0);
    }
    
    @Test(dataProvider="provideSignInUsers")
    public void testSignInFailure(String username, String password, int expect) throws Exception {
        HttpGet request = new HttpGet(getSignInUrl(username, password));
        Result result = result(request);
        
        Assert.assertEquals(result.getCode().intValue(), expect);
    }
    
    @Test(dataProvider="provideSignUpUsers")
    public void testSignUpFailure(String username, String password, int expect) throws Exception {
        HttpGet request = new HttpGet(getSignInUrl(username, password));
        Result result = result(request);
        
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
    
    @DataProvider
    private Object[][] provideSignUpUsers() {
        return new Object[][]{
            {"",        "",     1},
            {"chen",    "",     1},
            {"chen",    "123",  1},
            {"yuan",    "", 1},
        };
    }
    
    /**
     * 获取注册地址
     * @param username
     * @param password
     * @return
     */
    private String getSignUpUrl(String username, String password) {
        String host = "http://localhost:8080";
        String path = String.format("/user/signUp?username=%s&password=%s", username, password);
        return host + path;
    }
    
    /**
     * 获取登录地址
     * @param username
     * @param password
     * @return
     */
    private String getSignInUrl(String username, String password) {
        String host = "http://localhost:8080";
        String path = String.format("/user/signIn?username=%s&password=%s", username, password);
        return host + path;
    }
    
    /**
     * 获取请求响应
     * @param request
     * @return
     * @throws Exception
     */
    private Result result(HttpUriRequest request) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        response.close();
        client.close();
        
        ObjectMapper mapper = new ObjectMapper();
        Result result = mapper.readValue(json, Result.class);
        return result;
    }
}
