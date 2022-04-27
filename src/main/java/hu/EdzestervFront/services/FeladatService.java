package hu.EdzestervFront.services;

import hu.EdzestervFront.domain.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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

    public Feladat getFeladat(int id) {
        String url = API_URL+"/feladatok/{id}";
        Feladat feladat = restTemplate.getForObject(url, Feladat.class, id);
        return feladat;
    }

    public int addFeladat(String nev, int elegetettKcal, String leiras, String megjegyzes, String izomcsoport) {
        String url = API_URL+"/feladatok";
        Feladat feladat = new Feladat(nev, elegetettKcal,leiras, megjegyzes);
        HttpEntity<Feladat> requestEntity = new HttpEntity<>(feladat);
        try {
            ResponseEntity<Feladat> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Feladat.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }

    public int updateFeladat(int id, String leiras) {
        String url = API_URL+"/feladatok/{id}";
        Feladat feladat = new Feladat(id, leiras);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<Feladat> requestEntity = new HttpEntity<>(feladat);
        ResponseEntity<Feladat> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, Feladat.class, id);
        return responseEntity.getStatusCodeValue();
    }

    public int deleteFeladat(int id) {
        System.out.println("Service: "+(id-1));
        String url = API_URL+"/feladatok/{id}";
        restTemplate.delete(url, id);
        System.out.println("return 100");
        return 100;
    }

}
