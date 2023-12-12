package shopStore;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import shopStore.Simulations.TestPopulations;
import shopStore.Simulations.TestScenatio;
import shopStore.Simulations.UserJourney;
import shopStore.pageObjects.*;
import shopStore.sesion.UserSession;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class Test1 extends Simulation {

  private static final String URL = "https://acetoys.uk";

  private HttpProtocolBuilder httpProtocol = http
          .baseUrl(URL)
          .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
          .acceptEncodingHeader("gzip, deflate")
          .acceptLanguageHeader("ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");

  private ScenarioBuilder scn = scenario("AceToysSimulation")
          .exec(UserJourney.brouseStore)
          .exec(UserJourney.SeeSomsing);

  {
    setUp(TestPopulations.rampUsers).protocols(httpProtocol);
  }
}