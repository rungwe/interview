/**
 * Created by chaddyr on 7/3/17.
 */
public class Attribute {
    private String name;
    private int count;
    private double total;

    public  Attribute(String name, double amount) {
        this.name = name;
        this.count = 1;
        this.total = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    private void updateCount() {
        this.count += 1;
    }

    public double getTotal() {
        return total;
    }

    private void updateTotal(double total) {
        this.total += total;
    }

    public void mergeAttribute(Attribute otherAttribute) throws Exception {
        if(this.name.equals(otherAttribute.getName())){
            updateCount();
            updateTotal(otherAttribute.getTotal());
        }
        else {
            throw new Exception("cannot merge attributes with different keys");
        }
    }

    public String toString(){
        return name +", " + count + ", " + total;
    }
}
