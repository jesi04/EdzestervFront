package hu.EdzestervFront.services;

import hu.EdzestervFront.domain.Feladat;
import hu.EdzestervFront.domain.Felhasznalo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FeladatService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9099";


    public List<Feladat> getFeladatok() {
        String url = API_URL+"/feladatok";
        Feladat[] feladat = restTemplate.getForObject(url, Feladat[].class);
        return Arrays.asList(feladat);
    }
}
