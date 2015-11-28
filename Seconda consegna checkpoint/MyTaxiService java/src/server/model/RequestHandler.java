package server.model;

import java.util.ArrayList;

public class RequestHandler {
    
    //catalog that contains all the booking requests
    private static ArrayList <BookingRequest> requestsCatalog;
    
    //the only public method, a generic request is handled here
    public static void handleRequest(Request request){
        if (request instanceof TaxiNowRequest)
            forwardToDriver(request);
        else 
            storeRequest((BookingRequest) request);
    }
    
    //add a booking request to the catalog
    private static void storeRequest(BookingRequest request) {
        requestsCatalog.add(request);
    }

    //send the request to first queued driver in the corresponding city zone
    private static void forwardToDriver (Request request){
        for (CityZone zone: City.getCity()){
            if (zone.containsAddress(request.getStartingPoint())){
                QueueHandler.selectFirstDriver(zone.getQueue()).sendMessage(request);
            }
        }
    }
}
