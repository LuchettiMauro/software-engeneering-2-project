package server.model;

public interface Request extends Message {
    public User getUser ();
    public Address getStartingPoint();
    public Address getDestination();
    public boolean isShareable();
}
