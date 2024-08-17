package medicals.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import medicals.domain.MedicalsService;
import medicals.domain.Pilot;
import medicals.domain.PilotBuilder;
import medicals.domain.PilotClass;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.Map;

public class MedicalStepDefs {

    Pilot pilot;
    MedicalsService medicalsService = new MedicalsService();

    @Given("{string} is a {string} pilot born on {string}")
    public void is_a_pilot(String actor, String pilotClass, String dob) {

        pilot = PilotBuilder.pilotCalled(actor)
                .bornOn(LocalDate.parse(dob))
                .withClass(PilotClass.withLabel(pilotClass))
                .build();
    }

    @When("his last medical was {string}")
    public void his_last_medical_was(String date) {

        medicalsService.recordDateOfMedical(pilot, LocalDate.parse(date));
    }

    @Then("his next medical should be {string}")
    public void his_next_medical_should_be(String date) {

        Assertions.assertThat(medicalsService.findDateLimitForNextMedical(pilot))
                .isEqualTo(LocalDate.parse(date));
    }

    @When("his medical has expired on {string}")
    public void expired_medical(String date) {

        medicalsService.recordDateOfMedical(pilot, LocalDate.parse(date));
    }

    @When("his license status will restricted for a period")
    public void restricted_license(Map<String,String> parameters) {

        medicalsService.checkLicenseValidity(pilot, LocalDate.now());

        Assertions.assertThat(medicalsService.findDateLimitForNextMedical(pilot))
                .isEqualTo(LocalDate.parse(parameters.get("restricted until")));
        Assertions.assertThat(pilot.getPilotClass())
                .isEqualTo(PilotClass.withLabel(parameters.get("new class")));
    }
}


