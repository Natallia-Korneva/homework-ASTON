import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class RequestMethodsTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void setup() {
        // Устанавливаем базовую URL нашего API
        RestAssured.baseURI = "https://postman-echo.com";
    }

    //Тестирование GET-запроса
    @Test
    public void testGetMethod() throws JsonProcessingException {
        Response response = RestAssured.given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("/get");

        // Проверка статуса кода 200
        int statusCode = response.statusCode();
        assertEquals(200, statusCode);

        // Приводим полученный ответ к дереву JSON
        ObjectNode actualResponse = mapper.readValue(response.body().asString(), ObjectNode.class);

        // Формируем ожидаемый JSON-объект
        ObjectNode expectedResponse = mapper.createObjectNode();
        expectedResponse.put("args", mapper.createObjectNode()
                .put("foo1", "bar1")
                .put("foo2", "bar2"));
        expectedResponse.put("headers", mapper.createObjectNode()
                .put("host", "postman-echo.com")
                .put("accept-encoding", "gzip, br")
                .put("user-agent", "Apache-HttpClient/4.5.13 (Java/21.0.9)")
                .put("x-forwarded-proto", "https")
                .put("accept", "*/*"));
        expectedResponse.put("url", "https://postman-echo.com/get?foo1=bar1&foo2=bar2");

        // Глубокий анализ и сравнение JSON-объектов
        boolean isEqual = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedResponse)
                .equals(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(actualResponse));

        assertTrue(isEqual, "JSON objects are not deeply equal.");
    }

    //Тестирование POST-запроса
    @Test
    public void testPostMethod() throws JsonProcessingException {

        // Отправляем POST-запрос с телом {"test": "value"}
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"test\": \"value\"}")
                .when().post("/post");

        int statusCode = response.statusCode();
        assertEquals(200, statusCode);

        ObjectNode actualResponse = mapper.readValue(response.body().asString(), ObjectNode.class);

        ObjectNode expectedResponse = mapper.createObjectNode();
        expectedResponse.put("args", mapper.createObjectNode());

        expectedResponse.put("data", mapper.createObjectNode()
                .put("test", "value"));
        expectedResponse.put("files", mapper.createObjectNode());
        expectedResponse.put("form", mapper.createObjectNode());
        expectedResponse.put("headers", mapper.createObjectNode()
                .put("host", "postman-echo.com")
                .put("user-agent", "Apache-HttpClient/4.5.13 (Java/21.0.9)")
                .put("accept-encoding", "gzip, br")
                .put("accept", "*/*")
                .put("x-forwarded-proto", "https")
                .put("content-type", "application/json")
                .put("content-length", "17"));
        expectedResponse.put("json", mapper.createObjectNode()
                .put("test", "value"));
        expectedResponse.put("url", "https://postman-echo.com/post");

        boolean isEqual = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedResponse)
                .equals(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(actualResponse));

        assertTrue(isEqual, "JSON objects are not deeply equal.");
    }

       // Тестирование PUT-запроса
       @Test
       public void testPutMethod() throws JsonProcessingException {

           Response response = RestAssured.given()
                   .contentType("application/json")
                   .body("This is expected to be sent back as part of response body.")
                   .when().put("/put");

           int statusCode = response.statusCode();
           assertEquals(200, statusCode);

           ObjectNode actualResponse = mapper.readValue(response.body().asString(), ObjectNode.class);

           ObjectNode expectedResponse = mapper.createObjectNode();
           expectedResponse.put("args", mapper.createObjectNode());

           expectedResponse.put("data", "This is expected to be sent back as part of response body.");
           expectedResponse.put("files", mapper.createObjectNode());
           expectedResponse.put("form", mapper.createObjectNode());
           expectedResponse.put("headers", mapper.createObjectNode()
                   .put("host", "postman-echo.com")
                   .put("user-agent", "Apache-HttpClient/4.5.13 (Java/21.0.9)")
                   .put("accept-encoding", "gzip, br")
                   .put("accept", "*/*")
                   .put("x-forwarded-proto", "https")
                   .put("content-type", "application/json")
                   .put("content-length", "58"));
           expectedResponse.putNull("json");
           expectedResponse.put("url", "https://postman-echo.com/put");

           boolean isEqual = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedResponse)
                   .equals(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(actualResponse));

           assertTrue(isEqual, "JSON objects are not deeply equal.");
    }

    //    Тестирование Patch-запроса
    @Test
    public void testPatchMethod() throws JsonProcessingException {

        Response response = RestAssured.given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
                .when().patch("/patch");

        int statusCode = response.statusCode();
        assertEquals(200, statusCode);

        ObjectNode actualResponse = mapper.readValue(response.body().asString(), ObjectNode.class);

        ObjectNode expectedResponse = mapper.createObjectNode();
        expectedResponse.put("args", mapper.createObjectNode());

        expectedResponse.put("data", "This is expected to be sent back as part of response body.");
        expectedResponse.put("files", mapper.createObjectNode());
        expectedResponse.put("form", mapper.createObjectNode());
        expectedResponse.put("headers", mapper.createObjectNode()
                .put("host", "postman-echo.com")
                .put("user-agent", "Apache-HttpClient/4.5.13 (Java/21.0.9)")
                .put("accept-encoding", "gzip, br")
                .put("accept", "*/*")
                .put("x-forwarded-proto", "https")
                .put("content-type", "application/json")
                .put("content-length", "58"));
        expectedResponse.putNull("json");
        expectedResponse.put("url", "https://postman-echo.com/patch");

       boolean isEqual = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedResponse)
                .equals(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(actualResponse));

        assertTrue(isEqual, "JSON objects are not deeply equal.");
    }
    //   Тестирование DELETE-запроса
    @Test
    public void testDELETEMethod() throws JsonProcessingException {

        Response response = RestAssured.given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
                .when().delete("/delete");

        int statusCode = response.statusCode();
        assertEquals(200, statusCode);

        ObjectNode actualResponse = mapper.readValue(response.body().asString(), ObjectNode.class);

        ObjectNode expectedResponse = mapper.createObjectNode();
        expectedResponse.put("args", mapper.createObjectNode());

        expectedResponse.put("data", "This is expected to be sent back as part of response body.");
        expectedResponse.put("files", mapper.createObjectNode());
        expectedResponse.put("form", mapper.createObjectNode());
        expectedResponse.put("headers", mapper.createObjectNode()
                .put("host", "postman-echo.com")
                .put("user-agent", "Apache-HttpClient/4.5.13 (Java/21.0.9)")
                .put("accept-encoding", "gzip, br")
                .put("accept", "*/*")
                .put("x-forwarded-proto", "https")
                .put("content-type", "application/json")
                .put("content-length", "58"));
        expectedResponse.putNull("json");
        expectedResponse.put("url", "https://postman-echo.com/delete");

        boolean isEqual = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedResponse)
                .equals(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(actualResponse));

        assertTrue(isEqual, "JSON objects are not deeply equal.");
    }
}