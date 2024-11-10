package thread.org.flight;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class FlightDataTask implements Callable <List<FlightData>>{

    private FlightService flightService;

    private String src;
    private String dest;

    public FlightDataTask(FlightService flightService, String src, String dest) {
        this.flightService = flightService;
        this.src = src;
        this.dest = dest;
    }

    @Override
    public List<FlightData> call() throws Exception {
        return flightService.getFlights(src,dest);
//        return list.stream().map(impl->impl.getFlights(src,dest)).collect(Collectors.toList());

    }
}
