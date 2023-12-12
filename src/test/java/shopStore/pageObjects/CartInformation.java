package shopStore.pageObjects;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import io.gatling.javaapi.core.ChainBuilder;
public class CartInformation {
    public static ChainBuilder viewCart =
            doIf(session -> !session.getBoolean("customerLoggedIn"))
                    .then(exec(UserLoginAndOut.userLogToCabinet))
                    .exec(
                            http("View Cart")
                                    .get("/cart/view")
                                    .check(css("#CategoryHeader").is("Cart Overview"))
                    );
    public static ChainBuilder checkoutClick =
    exec(
            http("Checkout")
                    .get("/cart/checkout")
          );
}

//    public static ChainBuilder increaseProduct2 =
//exec(
//           http("Increase Product Quantity in Cart: Product Random")
//                        .get("/cart/add/2?cartPage=true")
//        );
//  public static ChainBuilder increaseProduct3 =
//           exec(
//                  http("Increase Product Quantity in Cart: Product Random")
//                          .get("/cart/add/3?cartPage=true")
//          );