package thread.org.flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class indigoImpl implements FlightService{
    @Override
    public List<FlightData> getFlights(String src, String dest) {
        List<FlightData> list = new ArrayList<>();
        list.add(new FlightData("src","dest",1000,new Date(), "Indigo",1));
        list.add(new FlightData("src","dest",2000,new Date(), "Indigo",2));
        list.add(new FlightData("src","dest",3000,new Date(), "Indigo",3));
        list.add(new FlightData("src","dest",4000,new Date(), "Indigo",4));
        list.add(new FlightData("src","dest",5000,new Date(), "Indigo",5));
        list.add(new FlightData("src","dest",6000,new Date(), "Indigo",6));
        return  list;

    }
}
