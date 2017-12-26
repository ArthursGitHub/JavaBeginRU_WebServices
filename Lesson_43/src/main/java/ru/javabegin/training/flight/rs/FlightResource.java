package ru.javabegin.training.flight.rs;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ru.javabegin.training.flight.interfaces.impls.SearchImpl;
import ru.javabegin.training.flight.spr.objects.City;
import ru.javabegin.training.flight.spr.objects.Country;

@Path("flight")
public class FlightResource {

    private SearchImpl searchImpl = new SearchImpl();

    public FlightResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("allcities")
    public ResponseList getAllCities() {
//        List<City> cityList = searchImpl.getAllCities();
        
        ResponseList responseList = new ResponseList();
        List<City> cityList = new ArrayList<>();
        byte[] flag = {1,2,3};
        City city = new City(1l, "NewYork", "Description", new Country(53, "USA", "Desc", flag, "86"), "4587");
        cityList.add(city);

        responseList.setList(cityList);
        
        return responseList;
    }
}
