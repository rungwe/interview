/**
 * Created by chaddyr on 7/3/17.
 */
public class MonthAttribute extends Attribute {

    public MonthAttribute(String name, double amount){
        super(name, amount);
        this.setName(name.substring(3));
    }
}
