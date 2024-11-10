package thread.org.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FlightClient {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<FlightService> list = new ArrayList<>();
        list.add(new AirIndiaImpl());
        list.add(new indigoImpl());
        list.add(new VistaraImpl());
//        FlightDataTask flightDataTask = new FlightDataTask();
        long start = System.currentTimeMillis();
        FlightDataTask flightDataTask1 = new FlightDataTask(new AirIndiaImpl(),"delhi","goa");
        FlightDataTask flightDataTask2 = new FlightDataTask(new indigoImpl(),"delhi","goa");
        FlightDataTask flightDataTask3 = new FlightDataTask(new VistaraImpl(),"delhi","goa");


        ExecutorService service = Executors.newFixedThreadPool(list.size());
//        List<FlightDataTask> listOfCollable = new ArrayList<>();
//        listOfCollable.add(flightDataTask1);
//        listOfCollable.add(flightDataTask2);
//        listOfCollable.add(flightDataTask3);
//        List<Future<List<FlightData>>> fData1 = service.invokeAll(listOfCollable);
        Future<List<FlightData>> fData1 = service.submit(flightDataTask1);
        Future<List<FlightData>> fData2 = service.submit(flightDataTask2);
        Future<List<FlightData>> fData3 = service.submit(flightDataTask3);


        List<List<FlightData>> lists = new ArrayList<>();

        lists.add(fData1.get());
        lists.add(fData2.get());
        lists.add(fData3.get());



        for (List<FlightData> l: lists)
        {
            for (FlightData flightData: l)
            {
                System.out.println(flightData);
            }
        }

        long end = System.currentTimeMillis();
        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("Total time it took : "+ (end-start));

    }
}
