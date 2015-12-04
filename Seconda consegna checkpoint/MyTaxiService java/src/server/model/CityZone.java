package server.model;

import java.util.ArrayList;

public class CityZone {
    
    private static CityZone zone;
    private Queue zoneQueue;
    private ArrayList<Address> zoneAddresses;

    //singleton pattern, there must be only one instance for each city zone
    private CityZone(){
        this.zoneQueue = new Queue();
    }
    
    public CityZone getCityZone() {
       if (zone == null){
           zone = new CityZone();
       }
       return zone;
    }
    
    //used to obtain the queue from a certain city zone
    public Queue getQueue(){
        return zoneQueue;
    }
    
    //used to search for an address in a specific city zone
    public boolean containsAddress(Address a){
        return zoneAddresses.contains(a);
    }
    
    //used to insert an address in a specific city zone 
    public void insertAddress(Address a){
        zoneAddresses.add(a);
    }
}
