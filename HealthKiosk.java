import java.util.Scanner;
import java.util.Random;

public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to Ashesi Health Kiosk!");

        // Task 1
        System.out.print("Enter service code P/L/T/C: ");
        char serviceCode = input.next().toUpperCase().charAt(0);
        String serviceName = "";
        double metricValue = 0;
        double bmiValue = 0;

        switch(serviceCode) {
            case 'P':
                serviceName = "Pharmacy";
                System.out.println(" Move to Pharmacy Desk");
                break;
            case 'L':
                serviceName = "Lab";
                System.out.println("Move to Lab Desk");
                break;
            case 'T':
                serviceName = "Triage";
                System.out.println("Move to Triage Desk");
                break;
            case 'C':
                serviceName = "Counseling";
                System.out.println("Move to Counseling Desk");
                break;
            default:
                System.out.println("Invalid code");
                return;
        }

        if(serviceName.equals("TRIAGE")) {
            System.out.print("Enter health metric (1=BMI, 2=Dosage, 3=Trig): ");
            int choice = input.nextInt();

            if(choice == 1) {

                System.out.print("Enter weight (kg): ");
                double weight = input.nextDouble();
                System.out.print("Enter height (m): ");
                double height = input.nextDouble();
                bmiValue = weight / (height * height);
                double roundedBMI = Math.round(bmiValue * 10) / 10.0;
                metricValue = Math.round(bmiValue);
                System.out.println("BMI: " + roundedBMI);

                if(roundedBMI < 18.5) {
                    System.out.println("Category: Underweight");
                } else if(roundedBMI <= 24.9) {
                    System.out.println("Category: Normal");
                } else if(roundedBMI <= 29.9) {
                    System.out.println("Category: Overweight");
                } else {
                    System.out.println("Category: Obese");
                }

            } else if(choice == 2) {

                System.out.print("Enter required dosage (mg): ");
                double dosage = input.nextDouble();
                int tablets = (int) Math.ceil(dosage / 250.0);
                metricValue = tablets;
                System.out.println("Number of tablets: " + tablets);

            } else if(choice == 3) {

                System.out.print("Enter angle (degrees): ");
                double angle = input.nextDouble();
                double radians = Math.toRadians(angle);
                double sinVal = Math.round(Math.sin(radians) * 1000) / 1000.0;
                double cosVal = Math.round(Math.cos(radians) * 1000) / 1000.0;
                metricValue = Math.round(Math.sin(radians) * 100); // sin*100 rounded
                System.out.println("sin: " + sinVal + " cos: " + cosVal);
            }
        }

        // Task 3
        char randChar = (char) ('A' + rand.nextInt(26));
        String id = "" + randChar;
        for(int i = 0; i < 4; i++) {
            int digit = rand.nextInt(7) + 3;
            id += digit;
        }
        System.out.println("Generated ID: " + id);

        if(id.length() != 5) {
            System.out.println("Invalid length");
            return;
        }
        if(!Character.isLetter(id.charAt(0))) {
            System.out.println("Invalid: first char must be a letter");
            return;
        }
        for(int i = 1; i < 5; i++) {
            if(!Character.isDigit(id.charAt(i))) {
                System.out.println("Invalid: last 4 must be digits");
                return;
            }
        }
        System.out.println("ID OK");

        // Task 4
        System.out.print("Enter your first name: ");
        String firstName = input.next();
        char base = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char)('A' + (base - 'A' + 2) % 26);
        String lastTwo = id.substring(3);
        String displayCode = shifted + lastTwo + "-" + (int)metricValue;
        System.out.println( displayCode);

        // Task 5

        if(serviceName.equals("TRIAGE")) {
            double roundedBMI = Math.round(bmiValue * 10) / 10.0;
            System.out.println("Summary: " + serviceName + " | ID=" + id + " | BMI=" + roundedBMI + " | Code=" + displayCode);
        } else {
            System.out.println("Summary: " + serviceName + " | ID=" + id + " | Code=" + displayCode);
        }
    }
}
