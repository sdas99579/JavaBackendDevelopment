package thread.org.flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VistaraImpl implements FlightService{
    @Override
    public List<FlightData> getFlights(String src, String dest) {
        List<FlightData> list = new ArrayList<>();
        list.add(new FlightData("src","dest",1000,new Date(), "Vistara",1));
        list.add(new FlightData("src","dest",2000,new Date(), "Vistara",2));
        list.add(new FlightData("src","dest",3000,new Date(), "Vistara",3));
        list.add(new FlightData("src","dest",4000,new Date(), "Vistara",4));
        list.add(new FlightData("src","dest",5000,new Date(), "Vistara",5));
        list.add(new FlightData("src","dest",6000,new Date(), "Vistara",6));
        return  list;

    }
}
