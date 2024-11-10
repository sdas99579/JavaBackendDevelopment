package thread.org.flight;

import java.util.Date;

public class FlightData {
    private String src;
    private String dest;
    private int price;
    private Date dateOfFlight;
    private String flightName;
    private int id;

    public FlightData(String src, String dest, int price, Date dateOfFlight, String flightName, int id) {
        this.src = src;
        this.dest = dest;
        this.price = price;
        this.dateOfFlight = dateOfFlight;
        this.flightName = flightName;
        this.id = id;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "src='" + src + '\'' +
                ", dest='" + dest + '\'' +
                ", price=" + price +
                ", dateOfFlight=" + dateOfFlight +
                ", flightName='" + flightName + '\'' +
                ", id=" + id +
                '}';
    }
}
