import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by chaddyr on 7/3/17.
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        String inputFile = null;
        String outputFile = null;
        try {
            inputFile = args[0];
            outputFile = args[1];
        } catch (Exception e) {
            System.out.print("Invalid arguments");
            System.exit(1);
        }

        Scanner file =  null;
        FileWriter output = null;

        try{
            file = new Scanner( new File(inputFile));
            output = new FileWriter(outputFile);
        } catch (Exception e){
            e.printStackTrace();
        }

        AttributeHash networks = new AttributeHash();
        AttributeHash months = new AttributeHash();
        AttributeHash products = new AttributeHash();

        String [] tempLine;
        file.nextLine();

        while (file.hasNext()) {
            tempLine =  file.nextLine().replace("'","").split(",");
            networks.put(new Attribute(tempLine[1], Double.parseDouble(tempLine[4])));
            months.put(new MonthAttribute(tempLine[2], Double.parseDouble(tempLine[4])));
            products.put(new Attribute(tempLine[3], Double.parseDouble(tempLine[4])));
        }

        output.write("Attribute, count, total\n");
        output.write(networks.toString());
        output.write(products.toString());
        output.write(months.toString());

        output.close();

        System.out.println("Task successfully finished, results generated in the file, "+ outputFile);



    }
}
