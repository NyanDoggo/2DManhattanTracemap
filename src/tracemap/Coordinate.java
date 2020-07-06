package tracemap;

public class Coordinate {
    public int i;
    public int j;
    public Coordinate(int i, int j){
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Coordinate{");
        sb.append("i=").append(i);
        sb.append(", j=").append(j);
        sb.append('}');
        return sb.toString();
    }
}
