package hu.EdzestervFront.services;

import hu.EdzestervFront.domain.Bemutato;
import hu.EdzestervFront.domain.Cel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BemutatoService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9099";

    public List<Bemutato> getBemutatok() {
        String url = API_URL+"/bemutatok";
        Bemutato[] cel = restTemplate.getForObject(url, Bemutato[].class);
        return Arrays.asList(cel);
    }
}
