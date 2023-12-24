package ProblemStatement9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class HealthBoxApp {
	
	private static Map<String, LocalDateTime> appointments = new HashMap<>();
	
      public static void main(String[] args) {
    	  Scanner scanner = new Scanner(System.in);

          while (true) {
              printMenu();
              System.out.println("=================================");
              System.out.println("Enter an Option");
              System.out.println("=================================");

              int option = scanner.nextInt();
              scanner.nextLine(); // Consume the newline character

              switch (option) {
                  case 1:
                      scheduleAppointment(scanner);
                      break;
                  case 2:
                      printAppointmentDetails();
                      break;
                  case 3:
                      rescheduleAppointment(scanner);
                      break;
                  case 4:
                      getReminder();
                      break;
                  case 5:
                      cancelAppointment();
                      break;
                  case 6:
                      System.out.println("Exiting HealthBox. Goodbye!");
                      System.exit(0);
                      break;
                  default:
                      System.out.println("Invalid option. Please choose a valid option.");
              }
          }
      }

      private static void printMenu() {
          System.out.println("1. Schedule an Appointment.");
          System.out.println("2. Print Appointment Details.");
          System.out.println("3. Reschedule an Appointment.");
          System.out.println("4. Get Reminder.");
          System.out.println("5. Cancel the Appointments.");
          System.out.println("6. Exit.");
      }

      private static void scheduleAppointment(Scanner scanner) {
          System.out.println("=================================");
          System.out.println("Enter Date  (dd/mm/yyyy)");
          String date = scanner.nextLine();
          System.out.println("Enter Time  (hh:mm)");
          String time = scanner.nextLine();
          System.out.println("Available Zones are");
          System.out.println("A : America/Anchorage");
          System.out.println("B : Europe/Paris");
          System.out.println("C : Asia/Tokyo");
          System.out.println("D : America/Phoenix");
          System.out.println("=================================");
          System.out.println("Select the Zone");
          System.out.println("=================================");

          String zoneSelection = scanner.nextLine();
          ZoneId selectedZone = getZoneId(zoneSelection);

          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
          LocalDateTime dateTime = LocalDateTime.parse(date + " " + time, formatter);
          ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, selectedZone);
          appointments.put(zoneSelection, zonedDateTime.toLocalDateTime());

          System.out.println("Successfully Booked");
      }

      private static void printAppointmentDetails() {
          System.out.println("=================================");
          System.out.println("Enter an Option");
          System.out.println("=================================");
          System.out.println("2");

          appointments.forEach((zone, dateTime) -> {
              System.out.println(dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a")) + " " + zone);
          });
      }

      private static void rescheduleAppointment(Scanner scanner) {
          System.out.println("=================================");
          System.out.println("Enter an Option");
          System.out.println("=================================");
          System.out.println("3");

          System.out.println("Current Appointment Date is : ");
          appointments.forEach((zone, dateTime) -> {
              System.out.println(dateTime.format(DateTimeFormatter.ofPattern("E, MMM d yyyy hh:mm a")) + " " + zone);
          });

          System.out.println("Kindly Enter Number of Days to be postponed");
          int daysToAdd = scanner.nextInt();
          scanner.nextLine(); // Consume the newline character

          System.out.println("Enter the new time in HH:mm");
          String newTime = scanner.nextLine();

          appointments.replaceAll((zone, dateTime) -> dateTime.plusDays(daysToAdd));

          System.out.println("Your Appointment has been rescheduled to :");
          appointments.forEach((zone, dateTime) -> {
              System.out.println(dateTime.format(DateTimeFormatter.ofPattern("E, MMM d yyyy hh:mm a")) + " " + zone);
          });
      }

      private static void getReminder() {
          System.out.println("=================================");
          System.out.println("Enter an Option");
          System.out.println("=================================");
          System.out.println("4");

          appointments.forEach((zone, dateTime) -> {
              LocalDateTime reminderTime = dateTime.minusDays(1);
              System.out.println(reminderTime.format(DateTimeFormatter.ofPattern("E, MMM d yyyy hh:mm a")));
          });
      }

      private static void cancelAppointment() {
          System.out.println("=================================");
          System.out.println("Enter an Option");
          System.out.println("=================================");
          System.out.println("5");

          appointments.clear();

          System.out.println("Appointment has been cancelled!!");
      }

      private static ZoneId getZoneId(String zoneSelection) {
          switch (zoneSelection) {
              case "A":
                  return ZoneId.of("America/Anchorage");
              case "B":
                  return ZoneId.of("Europe/Paris");
              case "C":
                  return ZoneId.of("Asia/Tokyo");
              case "D":
                  return ZoneId.of("America/Phoenix");
              default:
                  throw new IllegalArgumentException("Invalid zone selection: " + zoneSelection);
          }
	}

}
