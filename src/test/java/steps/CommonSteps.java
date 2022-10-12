package steps;

import business.ResponseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;

public class CommonSteps {

    private static final String BASE_URL = "http://open-school-dev.eu-central-1.elasticbeanstalk.com/";
    private static final String BASE_PATH = "api/v1/";

    @Given("Setup Rest Assured")
    public void setupRestAssured() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
    }
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        Assertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }
    @Then("Validate response JsonSchema {string}")
    public void validateResponseJsonSchema(String schemaPath) {
        ResponseUtils.validateResponseAgainstJSONSchema(ResponseUtils.getResponse(),schemaPath);
    }
}