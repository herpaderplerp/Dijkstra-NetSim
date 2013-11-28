public class Edge  {
  private final String id; 
  private final Vertex source;
  private final Vertex destination;
  private final double weight;
  private final double distance;
  
  public Edge(String id, Vertex source, Vertex destination, double weight, double distance) {
    this.id = id;
    this.source = source;
    this.destination = destination;
    this.weight = weight;
    this.distance = distance;
  }
 
  
  
  public String getId() {
    return id;
  }
  public Vertex getDestination() {
    return destination;
  }

  public Vertex getSource() {
    return source;
  }
  public double getWeight() {
    return weight;
  }
  
  @Override
  public String toString() {
    return source + " " + destination;
  }
  
  
} 