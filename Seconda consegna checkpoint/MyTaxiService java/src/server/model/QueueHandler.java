package server.model;

public class QueueHandler {

    public QueueHandler() {
    }
    
    //add a driver at the end of the queue
    public static void addDriver(Driver d, Queue queue){
        queue.add(d);
    }
    
    //remove the first driver in the queue
    public static void removeFirstDriver(Queue queue){
        queue.removeFirst();
    }
    
    //return the first element in the queue
    public static Driver selectFirstDriver(Queue queue){
        if (!queue.isEmpty())
            return queue.getFirst();
        else 
            return null; //here an error message can be sent
    }
    
    //move the first driver from top to bottom
    public static void moveFirstToBack(Queue queue){
        Driver d = selectFirstDriver(queue);
        addDriver(d,queue);
        removeFirstDriver(queue);
    }
}
