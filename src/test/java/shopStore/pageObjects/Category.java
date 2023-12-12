package shopStore.pageObjects;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
public class Category {

    private static final FeederBuilder<String> categoryFeeder =
            csv("data/categoryDetails.csv").circular();

    public static ChainBuilder categoryName =
            feed(categoryFeeder)
                    .exec(
                    http("Load Products List Page - Category: #{categoryName}")
                            .get("/category/#{categorySlug}")
                            .check(css("#CategoryName").isEL("#{categoryName}"))
            );

}
