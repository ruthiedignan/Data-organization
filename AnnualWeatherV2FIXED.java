
/**
 * This program will show the annual climate of Key West, FL in fahrenheit
 * or celsius.
 *
 * @author Ruthie Dignan
 * @version 1/25/2021
 */
import java.util.Scanner;
public class AnnualWeatherV2FIXED
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        //prompt user input
        System.out.printf("Celsius or Fahrenheit (C or F): ");
        String tempScale = in.next().toUpperCase();
        
        System.out.printf("Inches or Centimeters (i or c): ");
        String precipScale = in.next().toLowerCase();
        System.out.println();
        System.out.println();
    
        System.out.printf("%31s%n", "Climate Data");
        
        String location = "Key West, Florida";
        
        //intialize arrays
        double[] temperature = {70.3, 70.8, 73.8, 77.0, 80.7, 83.4, 84.5, 84.4, 83.4, 80.2, 76.3, 72.0};
        double[] precipitation = {2.2, 1.5, 2.9, 2.1, 3.5, 4.6, 3.3, 5.4, 5.5, 4.3, 2.6, 2.1};
        
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        double average = 0.0;
        double annual = 0.0;
        
        String precipMeasurement = "";
        
        //convert to celsius/centimeters
        if(tempScale.equals("C"))
        {
            for(int i = 0; i < temperature.length; i++)
            {
                temperature[i] = ((temperature[i] - 32) * 5) / 9;
            }
        }
        
        if(precipScale.equals("c"))
        {
            for(int i = 0; i< precipitation.length; i++)
            {
                precipitation[i] /= 0.39370;
            }
        }
        
        //calculate average/annual preicipitation, convert to text
        for(int i = 0; i< temperature.length; i++)
        {
            average += temperature[i];
        }
        average /= temperature.length;
        
        for(int i = 0; i < precipitation.length; i++)
        {
            annual += precipitation[i];
        }
        
        if(precipScale.equals("i"))
        {
            precipMeasurement = "in.";
        } else if(precipScale.equals("c"))
        {
            precipMeasurement = "cm.";
        }
        
        //print menu
        System.out.printf("%21s%s%n%n", "Location: ", location);
        System.out.printf("%23s%-5s","Temperature ",tempScale);
        System.out.printf("%s%s%n", "Precipitation ", precipMeasurement);
        System.out.println("*********************************************");
        
        for(int i = 0; i < months.length; i++)
        {
            System.out.printf("%-17s%-19.1f%-17.1f%n", months[i], temperature[i], precipitation[i]);
        }
        System.out.println("*********************************************");
        
        System.out.printf("%17s%-10.1f", "Average: ", average);
	System.out.printf("%s%-10.1f", "Annual: ", annual);
    }
}
