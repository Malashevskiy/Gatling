package shopStore.Simulations;
import io.gatling.javaapi.core.ChainBuilder;
import shopStore.pageObjects.AddProduct;
import shopStore.pageObjects.Category;
import shopStore.pageObjects.StatikPages;
import shopStore.pageObjects.UserLoginAndOut;
import shopStore.sesion.UserSession;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
public class UserJourney {
    public static final Duration LOW_PAUSE = Duration.ofMillis(1000);
    public static final Duration HIGH_PAUSE = Duration.ofMillis(3000);



    public static ChainBuilder brouseStore =
            exec(UserSession.initSession)
                    .exec(StatikPages.homePage)
                    .pause(HIGH_PAUSE)
                    .exec(StatikPages.ourStory)
                    .pause(LOW_PAUSE,HIGH_PAUSE)
                    .exec(StatikPages.getInTouch)
                    .pause(LOW_PAUSE,HIGH_PAUSE)
                    .repeat(3).on(
                            exec(Category.categoryName)
                                    .pause(HIGH_PAUSE)
                    );
 public static ChainBuilder SeeSomsing =
         exec(UserSession.initSession)
                 .exec(StatikPages.homePage)
                 .pause(LOW_PAUSE,HIGH_PAUSE)
                 .exec(Category.categoryName)
                 .pause(LOW_PAUSE,HIGH_PAUSE)
                 .exec(AddProduct.addProducts)
                 .pause(HIGH_PAUSE)
                 .exec(UserLoginAndOut.userLogToCabinet)
                                 .pause(HIGH_PAUSE, LOW_PAUSE)
                                 .exec(UserLoginAndOut.userLogOut)
                                 .pause(LOW_PAUSE, HIGH_PAUSE);



}
