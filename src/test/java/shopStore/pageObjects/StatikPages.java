package shopStore.pageObjects;
import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.Choice;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;


public class StatikPages {

    public static ChainBuilder homePage =
    exec(
            http("Load Home Page")
                          .get("/")
                          .check(status().is(200))
            .check(status().not(404),status().not(500))
            .check(substring("<h1>Ace Toys Online Store</h1>"))
            .check(css("#_csrf", "content").saveAs("csrfToken")) //генерация каждый раз нового токена
            );
    public static ChainBuilder ourStory =
            exec(
                    http("Load Our Story Page")
                    .get("/our-story")
                    .check(regex("was founded online in \\d{4}"))
            );
    public static ChainBuilder getInTouch =
            randomSwitch().on(
                    Choice.withWeight(10,exec(

                            http("Load Get In Touch Page")
                                    .get("/get-in-touch")
                                    .check(regex("as we are not actually a real store!"))))
                );

}
