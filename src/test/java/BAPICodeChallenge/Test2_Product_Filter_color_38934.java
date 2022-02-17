
package BAPICodeChallenge;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test2_Product_Filter_color_38934 {


    @Test
    public void CompareProductVsFilterCount() {

        //Hitting Product API
        Response response_product;
        response_product = given()
                .baseUri("https://api-cloud.aboutyou.de/v1/products")
               .queryParam("filters[color]", "38934")
                .when()
                .get();

        String responseBody = response_product.getBody().asString();
        JsonPath i = new JsonPath(response_product.asString());
        String total = i.getString("pagination.total");
        System.out.println("Products: total number of products for Brand ID 38934 is: " + total);

        //Hitting Filer API
        Response response_filter;
        response_filter = given()
                .baseUri("https://api-cloud.aboutyou.de/v1/filters/prices/values")
                .queryParam("filters[color]", "38934")
                .when()
                .get();

        String responseBody_filter = response_filter.getBody().asString();
        JsonPath j = new JsonPath(response_filter.asString());
        String filter_total = j.getString("[0].productCount");
        System.out.println("Filters: total number of products for color ID 38934 is: " + filter_total);

        Assert.assertEquals(total, filter_total, "Count not matching between Products and Filter API");

    }

}




