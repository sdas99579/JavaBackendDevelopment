package thread.org.flight;

import java.util.List;

public interface FlightService {
    List<FlightData> getFlights(String src, String dest);
}
