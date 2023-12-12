package shopStore.Simulations;
import io.gatling.javaapi.core.Choice;
import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
public class TestPopulations {

    public static PopulationBuilder instantUsers =
            TestScenatio.defaultLoadTest
                    .injectOpen(
                       nothingFor(5),
                            atOnceUsers(10)

                    );
    public static PopulationBuilder rampUsers =
            TestScenatio.defaultLoadTest
                    .injectOpen(
                            nothingFor(5),
                            rampUsers(10).during(20));
}
