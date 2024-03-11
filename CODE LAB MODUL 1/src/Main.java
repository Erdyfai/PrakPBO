import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                String name = getInput("Nama: ");
                char gender = getGenderInput();
                LocalDate birthDate = getBirthDateInput();
                
                displayUserInformation(name, gender, birthDate);
                
                break; 
            } catch (IllegalArgumentException | DateTimeParseException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static char getGenderInput() {
        while (true) {
            String genderInput = getInput("Jenis Kelamin (L/P): ");
            genderInput = genderInput.toUpperCase();
            if (genderInput.length() == 1 && (genderInput.charAt(0) == 'L' || genderInput.charAt(0) == 'P')) {
                return genderInput.charAt(0);
            }
            System.out.println("Please enter either 'L' or 'P'");
        }
    }

    private static LocalDate getBirthDateInput() {
        while (true) {
            try {
                String dateInput = getInput("Tanggal Lahir (yyyy-mm-dd): ");
                return LocalDate.parse(dateInput, DateTimeFormatter.ISO_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Please enter the date in the correct format (yyyy-mm-dd)");
            }
        }
    }

    private static void displayUserInformation(String name, char sex, LocalDate birthDate) {
        LocalDate now = LocalDate.now();
        Period age = Period.between(birthDate, now);

        System.out.println("Nama: " + name);
        System.out.println("Jenis Kelamin: " + (sex == 'L' ? "Laki-Laki" : "Perempuan"));
        System.out.println("Umur Anda: " + age.getYears() + " tahun " + age.getMonths() + " bulan");
    }
}