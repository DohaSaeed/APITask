import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class TaskTwo {

    @Test
    public void User_Stroy_Trella_Two()
    {
        Response extractedresp = given().log().all()
                .header("Authorization","dohasaeed61@gmail.com")
                .when()
                .get("https://case-api.trella.app/marketplace?lng=30&lat=30")
                .then().log().all().assertThat().statusCode(200)
                .assertThat().statusCode(HttpStatus.SC_OK)
                .assertThat().contentType(ContentType.JSON)
                .body("list.size()", is(3))
                .extract().response();


        ResponseBody body =  extractedresp.getBody();
        String bodyStringValue = body.asString();
        Assert.assertTrue(bodyStringValue.contains("key"));
        Assert.assertTrue(bodyStringValue.contains("numberOfBids"));
        Assert.assertTrue(bodyStringValue.contains("commodity"));
        Assert.assertTrue(bodyStringValue.contains("vehicleType"));
        Assert.assertTrue(bodyStringValue.contains("price"));
        Assert.assertTrue(bodyStringValue.contains("order"));
        Assert.assertTrue(bodyStringValue.contains("latitude"));
        Assert.assertTrue(bodyStringValue.contains("longitude"));
        Assert.assertTrue(bodyStringValue.contains("name"));
    }

}
