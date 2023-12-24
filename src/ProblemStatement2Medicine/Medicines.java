package ProblemStatement2Medicine;

interface MedicineInfo {
    void displayLabel(String companyName, String address);
}

public class Medicines {

	public static void main(String[] args) {
		
		 MedicineInfo[] medicines = new MedicineInfo[10];

	        for (int i = 0; i < medicines.length; i++) {
	            int randomMedicineType = (int) (Math.random() * 3) + 1; // Randomly generate 1, 2, or 3

	            // Implement MedicineInfo interface using Lambda Expressions
	            if (randomMedicineType == 1) {
	                medicines[i] = (companyName, address) ->
	                System.out.println("Tablet - Store in a cool dry place\n" +
	                        "Company: " + companyName + "\nAddress: " + address);
	            } else if (randomMedicineType == 2) {
	                medicines[i] = (companyName, address) ->
	                        System.out.println("Syrup - Shake well before use\n" +
	                         "Company: " + companyName + "\nAddress: " + address);
	            } else {
	                medicines[i] = (companyName, address) ->
	                     System.out.println("Ointment - For external use only\n" +
	                         "Company: " + companyName + "\nAddress: " + address);
	            }

	            // Display the label using polymorphic behavior
	            String companyName = "PharmaCompany" + i;
	            String address = "Street " + i + ", City";
	            medicines[i].displayLabel(companyName, address);
	            System.out.println("--------------------------");
	        }

	}

}