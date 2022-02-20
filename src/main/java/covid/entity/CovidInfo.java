package covid.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class CovidInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int department;
    private Date date;
//    1
    private int quarantine;
//    2
    private int distance;
//    3
    private int suspended;
//    4
    private int research;
    private int researchToday;
//    5
    private int onTreatment;
    private int onTreatmentAmbulance;
    private int onTreatmentStationary;
//    6
    private int covidToday;
//    7
    private int confirmedCovid;
    private int confirmedCovidToday;
//    8
    private int recoveredTotal;
    private int recoveredToday;
//    9
    private int lethalTotal;
    private int lethalToday;
//    10
    private int selfisolation65;
//    11
    private int presentTotal;
//    12
    private int vaccinatedTotal;
    private int firstSputnik;
    private int secondSputnik;
    private int firstEpivak;
    private int secondEpivak;
    private int firstCovivak;
    private int secondCovivak;
    private int sputnikLight;
    private int vaccinatedToday;
//    13
    private int revaccinated;
//    14
    private int revaccinatedTotal;
    private int revaccinatedToday;
//    15
    private int masksOne;
//    16
    private int masksMany;
//    17
    private int respirators;
//    18
    private int gloves;
//    19
    private int overalls;
//    20
    private int overallsMembrana;
//    21
    private int overallsMembranaHard;
//    22
    private int antiseptik;
//    23
    private int chlorine;
}
