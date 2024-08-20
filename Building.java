import java.util.Objects;

public class Building implements BuildingInterface{
	
    static class Triplet{
        private Building b1;
        private Building b2;
        private int distance;
        public Triplet(Building b1,Building b2,int d){
            this.b1 = b1;
            this.b2 = b2;
            distance= d;
        }
        public Building getB1(){ return b1;}
        public Building getB2(){ return b2;}
        public int getDistance(){ return distance;}

    }
    
    private int x;
    private int y;
    private String name;
    private String address;

    public Building(int x, int y, String name,String address){
        this.x = x;
        this.y = y;
        this.address = address;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString(){
        return name + address;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Building && ((Building) o).x == x && ((Building) o).y==y && Objects.equals(((Building) o).name, name) && Objects.equals(((Building) o).address, address);
    }

    @Override
    public int hashCode(){
        return x*13 + y*17 + name.hashCode() + address.hashCode();
    }

}
