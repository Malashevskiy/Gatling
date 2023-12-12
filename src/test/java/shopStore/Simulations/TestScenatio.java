package shopStore.Simulations;

import io.gatling.javaapi.core.Choice;
import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
public class TestScenatio {
    public static ScenarioBuilder defaultLoadTest =
            scenario("Defolt Load Test")
                    .during(30)
                    .on(
                            randomSwitch()
                                    .on(
                                            Choice.withWeight(60,exec(UserJourney.SeeSomsing)),
                                            Choice.withWeight(40,exec(UserJourney.brouseStore))
                                    )
                    );
    public static ScenarioBuilder highLoadTest =
            scenario("High Load Test")
                    .during(50)
                    .on(
                            randomSwitch()
                                    .on(
                                            Choice.withWeight(20,exec(UserJourney.SeeSomsing)),
                                            Choice.withWeight(80,exec(UserJourney.brouseStore))
                                    )
                    );
}
