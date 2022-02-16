# api-testing
# Below are the test cases I have prepared so far.

1. Hit the filters endpoint without any filters. Take any one brand and note down the total number of products available.
Now, hit the products endpoint with filters[brand]='brand_id' of the brand which was selected in that step. Notice the "total" tag under pagination block of response. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters?&with=values

Products:
https://api-cloud.aboutyou.de/v1/products?filters[brand]=1127

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

2. Hit the filters endpoint without any filters. Take any one color and note down the total number of products available.
Now, hit the products endpoint with filters[color]='color_id' of the brand which was selected in that step. Notice the "total" tag under pagination block of response. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters?&with=values

Products:
https://api-cloud.aboutyou.de/v1/products?filters[color]=38934

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

3. Hit the filters endpoint without any filters. Take any one categoryShopFilterSizes and note down the total number of products available.
Now, hit the products endpoint with filters[categoryShopFilterSizes]='categoryShopFilterSizes_id' of the brand which was selected in that step. Notice the "total" tag under pagination block of response. Both should match.

Filters:
https://api-cloud.aboutyou.de/v1/filters?&with=values

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
