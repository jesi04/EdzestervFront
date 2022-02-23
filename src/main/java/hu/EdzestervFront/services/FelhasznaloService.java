package hu.EdzestervFront.services;

import hu.EdzestervFront.domain.Felhasznalo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FelhasznaloService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9099";


    public List<Felhasznalo> getFelhasznalok() {
        String url = API_URL+"/felhasznalok";
        Felhasznalo[] felhasznalo = restTemplate.getForObject(url, Felhasznalo[].class);
        return Arrays.asList(felhasznalo);
    }
}
