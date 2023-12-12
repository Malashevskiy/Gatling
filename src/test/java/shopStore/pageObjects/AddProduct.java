package shopStore.pageObjects;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static shopStore.sesion.UserSession.checkProdukt;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;

public class AddProduct {
    private static final FeederBuilder<Object> productFeeder =
            jsonFile("data/productDeteils.json").random();
    public static ChainBuilder addProducts =
            feed(productFeeder)
                    .exec(checkProdukt)
                    .exec(
                            http("Add Product to Cart: ProductID: #{name}")
                                    .get("/cart/add/#{id}")
                                    .check(substring("You have <span>#{itemsInBasket}</span> products in your Basket."))

            );

}
