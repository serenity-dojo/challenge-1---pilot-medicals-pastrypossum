package medicals.domain;

import lombok.*;
import net.bytebuddy.asm.Advice;
import net.serenitybdd.model.i8n.LocalisedLabels;

import java.time.LocalDate;
import java.util.Map;
import java.time.temporal.ChronoUnit;

//@Data @Builder
public class Pilot {
    private String pilotName;
    private PilotClass pilotClass;
    private LocalDate birthDate;

    public Pilot(String pilotName, PilotClass pilotClass) {
        this.pilotName = pilotName;
        this.pilotClass = pilotClass;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setPilotClass(PilotClass pilotClass) {
        this.pilotClass = pilotClass;
    }

    public PilotClass getPilotClass() {
        return pilotClass;
    }

    public long getPilotAge() {
        return ChronoUnit.YEARS.between( birthDate , LocalDate.now() );
    }
}
