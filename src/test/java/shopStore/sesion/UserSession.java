package shopStore.sesion;
import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
public class UserSession {

    public static ChainBuilder initSession =

            exec(flushCookieJar())
                    .exec(session -> session.set("customerLoggedIn", false))
                    .exec(session -> session.set("itemsInBasket", 0));

    public static ChainBuilder checkProdukt =
            exec(session -> {
        int itemsInBasket = session.getInt("itemsInBasket");
        return session.set("itemsInBasket", (itemsInBasket + 1));
    });
}
