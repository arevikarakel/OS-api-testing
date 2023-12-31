package steps.discussionForum;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manager.GettingIdManager;
import org.assertj.core.api.Assertions;
import providers.dataProviders.Endpoints;
import providers.dataProviders.MessageProvider;
import providers.dataProviders.SharedTestData;
import steps.BaseSteps;
import utils.api.RequestsUtils;
import utils.api.ResponseUtils;

public class GettingQuestionsAndAnswersByIdSteps extends BaseSteps {

    @When("Get question by Id")
    public void getQuestionById() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        int peersQuestionId = SharedTestData.getQuestionIdToThePeers();
        logger.info("peersQuestionId is ---->{}", peersQuestionId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        pathVariables.put("peersQuestionId", peersQuestionId);
        RequestsUtils.get(Endpoints.GET_QUESTION_TO_PEERS_BY_ID.url, SharedTestData.getToken(), pathVariables);
    }

    @And("Validate the provided question response body by json schema")
    public void validateTheProvidedQuestionResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/discussionForum/GetQuestionToPeersResponseSchema.json");
    }

    @When("Get question by the wrong questionId")
    public void getQuestionByTheWrongQuestionId() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        pathVariables.put("peersQuestionId", 0);
        RequestsUtils.get(Endpoints.GET_QUESTION_TO_PEERS_BY_ID.url, SharedTestData.getToken(), pathVariables);
    }

    @When("Get question by the wrong enrolledCourseId")
    public void getQuestionByTheWrongEnrolledcourseId() {
        GettingIdManager gettingIdManager = new GettingIdManager();
        int peersQuestionIdFromDB = gettingIdManager.getFromPeersQuestionTableFirstId();
        logger.info("EnrolledCourseId is ---->{}", 0);
        pathVariables.put("enrolledCourseId", 0);
        logger.info("PeersQuestionIdFromDB is ------>{}", peersQuestionIdFromDB);
        pathVariables.put("peersQuestionId", peersQuestionIdFromDB);
        RequestsUtils.get(Endpoints.GET_QUESTION_TO_PEERS_BY_ID.url, SharedTestData.getToken(), pathVariables);
    }

    @When("Get answer by Id")
    public void getAnswerById() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        int peersAnswerId = SharedTestData.getAnswerIdToThePeers();
        logger.info("peersAnswerId is ---->{}", peersAnswerId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        pathVariables.put("answerId", peersAnswerId);
        RequestsUtils.get(Endpoints.GET_ANSWER_TO_PEERS_QUESTION_BY_ID.url, SharedTestData.getToken(), pathVariables);
    }

    @And("Validate the provided answer response body by json schema")
    public void validateTheProvidedAnswerResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/discussionForum/GetAnswerToPeersResponseSchema.json");
    }

    @When("Get answer by invalid Id")
    public void getAnswerByInvalidId() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        logger.info("peersAnswerId is ---->{}", 0);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        pathVariables.put("answerId", 0);
        RequestsUtils.get(Endpoints.GET_ANSWER_TO_PEERS_QUESTION_BY_ID.url, SharedTestData.getToken(), pathVariables);
    }

    @When("Get all answers to peers")
    public void getAllAnswersToPeers() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        int peersQuestionId = SharedTestData.getQuestionIdToThePeers();
        logger.info("peersQuestionId is ---->{}", peersQuestionId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        pathVariables.put("peersQuestionId", peersQuestionId);
        RequestsUtils.get(Endpoints.GET_ALL_ANSWERS_RELATED_TO_PEERS_QUESTION.url, SharedTestData.getToken(), pathVariables);
    }

    @And("Validate all answers response body by json schema")
    public void validateAllAnswesResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/discussionForum/GetAllAnswersToPeersResponseSchema.json");
    }

    @And("Validate error message about unauthorized user")
    public void validateErrorMessageAboutUnautorizedUser() {
        String expectedErrorMessage = MessageProvider.getPropertyValue("unauthorizedUser");
        logger.info("ExpectedErrorMessage is ----->{}",expectedErrorMessage);
        String actualErrorMessage = ResponseUtils.getStringFromResponse("message");
        logger.info("ActualErrorMessage is ----->{}",actualErrorMessage);
        Assertions.assertThat(actualErrorMessage).contains(expectedErrorMessage);
    }

    @When("Get all answers to peers without registration")
    public void getAllAnswersToPeersWithoutRegistration() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        int peersQuestionId = SharedTestData.getQuestionIdToThePeers();
        logger.info("peersQuestionId is ---->{}", peersQuestionId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        pathVariables.put("peersQuestionId", peersQuestionId);
        RequestsUtils.get(Endpoints.GET_ALL_ANSWERS_RELATED_TO_PEERS_QUESTION.url, "", pathVariables);
    }

    @When("Get question to mentor by Id")
    public void getQuestionToMentorById() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        int mentorQuestionId = SharedTestData.getQuestionToTheMentor();
        logger.info("peersQuestionId is ---->{}", mentorQuestionId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        pathVariables.put("questionId", mentorQuestionId);
        RequestsUtils.get(Endpoints.GET_MENTOR_QUESTION_BY_ID.url, SharedTestData.getToken(), pathVariables);
    }

    @When("Get question to mentor by the wrong questionId")
    public void getQuestionToMentorByTheWrongQuestionId() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        pathVariables.put("questionId", 0);
        RequestsUtils.get(Endpoints.GET_MENTOR_QUESTION_BY_ID.url, SharedTestData.getToken(), pathVariables);
    }

    @When("Get question to mentor by the wrong enrolledCourseId")
    public void getQuestionToMentorByTheWrongEnrolledCourseId() {
        GettingIdManager gettingIdManager = new GettingIdManager();
        int mentorQuestionIdFromDB = gettingIdManager.getFromMentorQuestionTableFirstId();
        logger.info("EnrolledCourseId is ---->{}", 0);
        pathVariables.put("enrolledCourseId", 0);
        logger.info("MentorQuestionIdFromDB is ------>{}", mentorQuestionIdFromDB);
        pathVariables.put("questionId", mentorQuestionIdFromDB);
        RequestsUtils.get(Endpoints.GET_MENTOR_QUESTION_BY_ID.url, SharedTestData.getToken(), pathVariables);
    }

    @When("Get all questions to peers")
    public void getAllQuestionsToPeers() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        RequestsUtils.get(Endpoints.GET_ALL_QUESTIONS_TO_PEERS.url, SharedTestData.getToken(), pathVariables);
    }

    @And("Validate all questions response body by json schema")
    public void validateAllQuestionsResponseBodyByJsonSchema() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/discussionForum/GetAllQuestionsResponseSchema.json");
    }

    @When("Get all questions to peers without registration")
    public void getAllQuestionsToPeersWithoutRegistration() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        RequestsUtils.get(Endpoints.GET_ALL_QUESTIONS_TO_PEERS.url, "", pathVariables);
    }

    @When("Get all questions to mentors")
    public void getAllQuestionsToMentors() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        RequestsUtils.get(Endpoints.GET_ALL_MENTORS_QUESTION.url, SharedTestData.getToken(), pathVariables);
    }

    @When("Get all questions to mentors without registration")
    public void getAllQuestionsToMentorsWithoutRegistration() {
        int enrolledCourseId = SharedTestData.getEnrolledCourseId();
        logger.info("EnrolledCourseId is ---->{}", enrolledCourseId);
        pathVariables.put("enrolledCourseId", enrolledCourseId);
        RequestsUtils.get(Endpoints.GET_ALL_MENTORS_QUESTION.url, "", pathVariables);
    }
}
