
package BAPICodeChallenge;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test8_Product_Filter_category_236147_ProductCount_check_MinMaxPrice {


    @Test
    public void CompareProductVsFilterCount() {


        //Hitting Filer API
        Response response_filter;
        response_filter = given()
                .baseUri("https://api-cloud.aboutyou.de/v1/filters/prices/values")
                .queryParam("filters[category]", "236147")
                .when()
                .get();

        String responseBody_filter = response_filter.getBody().asString();
        JsonPath j = new JsonPath(response_filter.asString());
        String filter_total = j.getString("[0].productCount");
        String minprice = j.getString("[0].min");
        String maxprice = j.getString("[0].max");
        System.out.println("Filters: total number of products available for category 236147 is: " + filter_total);

        //Hitting Product API
        Response response_product;
        response_product = given()
                .baseUri("https://api-cloud.aboutyou.de/v1/products")
                .queryParam("filters[category]", "236147")
                .queryParam("filters[minPrice]", minprice)
                .queryParam("filters[maxPrice]", maxprice)
                .when()
                .get();

        String responseBody = response_product.getBody().asString();
        //System.out.println(responseBody);
        JsonPath i = new JsonPath(response_product.asString());
        String total = i.getString("pagination.total");
        System.out.println("Products: total number of products for category 236147 is: " + total);


        Assert.assertEquals(total, filter_total, "Count not matching between Products and Filter API");

    }

}




