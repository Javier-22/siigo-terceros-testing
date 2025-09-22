package siigo.utils;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ReportUtils {

    public static void saveResponseToReport(Actor actor, String title) {
        Response response = LastResponse.received().answeredBy(actor);

        String reportContent = String.format(
                "URL: %s\nStatus: %d\nHeaders: %s\n\nBody: %s",
                response.getStatusLine(),
                response.getStatusCode(),
                response.getHeaders(),
                response.getBody().asPrettyString()
        );

        Serenity.recordReportData()
                .withTitle(title)
                .andContents(reportContent);
    }

    public static void saveResponseToReport(Actor actor) {
        saveResponseToReport(actor, "API Response");
    }
}
