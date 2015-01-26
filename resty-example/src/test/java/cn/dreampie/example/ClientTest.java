package cn.dreampie.example;

import cn.dreampie.client.Client;
import cn.dreampie.client.ClientRequest;
import cn.dreampie.client.HttpMethod;
import cn.dreampie.common.util.json.Jsoner;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import cn.dreampie.resource.user.model.User;

import java.util.HashMap;

/**
 * Created by ice on 15-1-4.
 */
@FixMethodOrder(MethodSorters.JVM)
public class ClientTest {

  private Client client;

  @Before
  public void setUp() throws Exception {
    client = new Client("http://127.0.0.1:8081/api/v1.0");
  }

  @Test
  public void testLogin() {
    ClientRequest request = new ClientRequest("/sessions", HttpMethod.POST);
    request.addParameter("username", "测试的").addParameter("password", "123").addParameter("rememberMe", "true");
    System.out.println(client.build(request).ask());
  }

  @Test
  public void testLogut() {
    ClientRequest request = new ClientRequest("/sessions", HttpMethod.DELETE);
    System.out.println(client.build(request).ask());
  }

  @Test
  public void testDelete() {
    ClientRequest request = new ClientRequest("/users/1", HttpMethod.DELETE);
    System.out.println(client.build(request).ask());
  }

  @Test
  public void testUpdate() {
    ClientRequest request = new ClientRequest("/users", HttpMethod.PUT);
    request.addParameter("user", "{\"id\":\"1\",\"username\":\"k\"}");
    System.out.println(client.build(request).ask());
  }

  @Test
  public void testSave() {
    ClientRequest request = new ClientRequest("/users", HttpMethod.POST);
    request.addParameter("user", Jsoner.toJSONString(new HashMap<String, Object>() {{
      put("sid", 2);
      put("username", "test");
      put("providername", "test");
      put("password", "123456");
    }}));
    System.out.println(client.build(request).ask());
  }
}
