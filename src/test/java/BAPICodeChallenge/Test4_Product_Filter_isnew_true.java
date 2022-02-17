
package BAPICodeChallenge;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Test4_Product_Filter_isnew_true {


    @Test
    public void CompareProductVsFilterCount() {

        //Hitting Product API
        Response response_product;
        response_product = given()
                .baseUri("https://api-cloud.aboutyou.de/v1/products")
               .queryParam("filters[isnew]", "true")
                .when()
                .get();

        String responseBody = response_product.getBody().asString();
        JsonPath i = new JsonPath(response_product.asString());
        String total = i.getString("pagination.total");
        System.out.println("total number of new products are: " + total);

        //Hitting Filer API
        Response response_filter;
        response_filter = given()
                .baseUri("https://api-cloud.aboutyou.de/v1/filters/isnew/values")
                .when()
                .get();

        String responseBody_filter = response_filter.getBody().asString();
        JsonPath j = new JsonPath(response_filter.asString());
        String filter_total = j.getString("[1].productCount");
        System.out.println("total number of products which are new is: " + filter_total);

        Assert.assertEquals(total, filter_total, "Count not matching between Products and Filter API");

    }

}




