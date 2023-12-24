package ProblemStatement2;

public class Musics {

	public static void main(String[] args) {
		
		 Instrument[] instruments = new Instrument[10];

	        // Assign different types of instruments to Instrument references
	        for (int i = 0; i < instruments.length; i++) {
	            if (i % 3 == 0) {
	                instruments[i] = (Instrument) () -> System.out.println("Piano is playing tan tan tan tan");
	            } else if (i % 3 == 1) {
	                instruments[i] = (Instrument) () -> System.out.println("Flute is playing toot toot toot toot");
	            } else {
	                instruments[i] = (Instrument) () -> System.out.println("Guitar is playing tin tin tin");
	            }
	        }

	        // Check for polymorphic behavior of play method
	        for (int i = 0; i < instruments.length; i++) {
	            instruments[i].play();

	            // Use the instanceof operator to print the object's type
	            if (instruments[i] instanceof Piano) {
	                System.out.println("Object at index " + i + " is a Piano");
	            } else if (instruments[i] instanceof Flute) {
	                System.out.println("Object at index " + i + " is a Flute");
	            } else if (instruments[i] instanceof Guitar) {
	                System.out.println("Object at index " + i + " is a Guitar");
	            }
	        }
	}

}

