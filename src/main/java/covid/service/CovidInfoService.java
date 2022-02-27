package covid.service;

import covid.entity.CovidInfo;
import covid.entity.Person;
import covid.repository.CovidInfoRepository;
import covid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class CovidInfoService {
    private final CovidInfoRepository covidInfoRepository;
    private final UserRepository userRepository;

    @Autowired
    public CovidInfoService(CovidInfoRepository covidInfoRepository,
                            UserRepository userRepository) {
        this.covidInfoRepository = covidInfoRepository;
        this.userRepository = userRepository;
    }

    public CovidInfo getCovidInfo(Principal principal) {
        int department = userRepository.findByUsername(principal.getName()).getDepartment();
        return covidInfoRepository.findByDepartment(department);
    }

    public CovidInfo createCovidInfo(CovidInfo covidInfo, Principal principal) {
        int department = userRepository.findByUsername(principal.getName()).getDepartment();
        CovidInfo temp = covidInfoRepository.findByDepartment(department);
        if (temp == null)
            return covidInfoRepository.save(covidInfo);
        else
        {
            temp.setDepartment(covidInfo.getDepartment());
            temp.setQuarantine(covidInfo.getQuarantine());
            for (Person person : covidInfo.getPersonList())
                temp.addPerson(person);
            return covidInfoRepository.save(temp);
        }
    }
}
