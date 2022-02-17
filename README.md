# api-testing
# Below are the test cases I have prepared so far.
#To generate the TestNG Reports, click on the package from project explorer, click on run. It will run all the Test cases under the package. And the emailable HTML report can be found under \test-output\emailable-report.html which would show the report with passed and failed test cases.


1. Hit the filters endpoint with any brand as filter. Note down the total number of products available.
Now, hit the products endpoint with filters[brand]='brand_id' of the brand which was selected in that step. Notice the "total" tag under pagination block of response. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters/prices/values?filters[brand]=1127

Products:
https://api-cloud.aboutyou.de/v1/products?filters[brand]=1127

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2. Hit the filters endpoint with any color as filter. Note down the total number of products available.
   Now, hit the products endpoint with filters[color]='color_id' of the color which was selected in that step. Notice the "total" tag under pagination block of response. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters/prices/values?filters[color]=38934

Products:
https://api-cloud.aboutyou.de/v1/products?filters[color]=38934

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3. Hit the filters endpoint with any categoryShopFilterSizes. Note down the total number of products available.
Now, hit the products endpoint with filters[categoryShopFilterSizes]='categoryShopFilterSizes_id' of the brand which was selected in that step. Notice the "total" tag under pagination block of response. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters/prices/values?filters[categoryShopFilterSizes]=72759

Products:
https://api-cloud.aboutyou.de/v1/products?filters[categoryShopFilterSizes]=72759


----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

4. Hit the filters endpoint with groupName as isnew which would give us number of products which are new and which are not. Note down the count of products which are new. Now, hit the Products endpoint with filters isnew as true and verify the total tag under pagination block. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters/isnew/values

Products:
https://api-cloud.aboutyou.de/v1/products?filters%5Bisnew%5D=true&page=1&perPage=100

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

5. Hit the filters endpoint with groupName as isnew which would give us number of products which are new and which are not. Note down the count of products which are not new. Now, hit the Products endpoint with filters isnew as false and verify the total tag under pagination block. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters/isnew/values

Products:
https://api-cloud.aboutyou.de/v1/products?filters%5Bisnew%5D=false&page=1&perPage=5

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

6.  Hit the filters endpoint with groupname as sales and brand as 1127. Note down the number of products which are on sale for this brand.
    Now, hit the products endpoint with filters[brand]='brand_id' of the brand which was selected in that step and filters[sale]='true'. Notice the "total" tag under pagination block of response. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters/sale/values?filters[brand]=1127

Products:
https://api-cloud.aboutyou.de/v1/products?filters[sale]=true&page=1&perPage=100&filters[brand]=1127

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

7.  Hit the filters endpoint with groupname as sales and brand as 1127. Note down the number of products which are not on sale for this brand.
    Now, hit the products endpoint with filters[brand]='brand_id' of the brand which was selected in that step and filters[sale]='false'. Notice the "total" tag under pagination block of response. Both should match.


Filters:
https://api-cloud.aboutyou.de/v1/filters/sale/values?filters[brand]=1127

Products:
https://api-cloud.aboutyou.de/v1/products?filters[sale]=false&page=1&perPage=100&filters[brand]=1127

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

8. Hit the filters endpoint with groupname as prices and category as 236147. Take the min and max values from the response. Note down the value of productCount. Now, hit the products endpoint with filters[category]=236147 and filters[minPrice]= min value from filters response and filters[maxPrice] = max value from filters response. Compare the "total" tag under pagination block of response with productCount from filters response. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters/prices/values?filters[category]=236147

Products:
https://api-cloud.aboutyou.de/v1/products?filters[minPrice]=195&filters[maxPrice]=749900&filters[category]=236147

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

9. Hit the filters endpoint with category which is invalid like - 1111000000 and see that we are getting null response. Now hit the products endpoint with that category as given in filters endpoint. Verify the response. Total should be 0.
Filters:
https://api-cloud.aboutyou.de/v1/filters/prices/values?filters[category]=1111000000

Products:
https://api-cloud.aboutyou.de/v1/products?filters[category]=1111000000


