package medicals.domain;

import java.time.LocalDate;

public class PilotBuilder {

    private String pilotName;
    private PilotClass pilotClass;
    private int age;
    private LocalDate birthDate;

    public PilotBuilder(String pilotName){
        this.pilotName = pilotName;
    }

    public static PilotBuilder pilotCalled(String pilotName) {
        return new PilotBuilder(pilotName);
    }

    public PilotBuilder aged(int age) {
        this.age = age;
        return this;
    }

    public PilotBuilder bornOn(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PilotBuilder withClass(PilotClass pilotClass) {
        this.pilotClass = pilotClass;
        return this;
    }

    public Pilot build() {

        Pilot pilot = new Pilot(pilotName,pilotClass);
        pilot.setBirthDate(birthDate);

        return pilot;
    }
}
