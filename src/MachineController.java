import java.util.Scanner;

public class MachineController {
	
	public static void main(String[] args) {
		Machine machine = new Machine();
		int currentCycle= 0;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of blocks in your system: ");
		int numOfBlocks = scanner.nextInt();
		for (int i=0; i<numOfBlocks; i++)
		{
			System.out.print("Enter the capacity for a block " + i +  ": ");
			machine.addBlock(scanner.nextInt());
		}
		machine.executeCycle(currentCycle);
		System.out.println("\n\n" + machine.displayMachine());
		
		System.out.println("\n\nPress ENTER to execute cycles, Press X and then ENTER to exit:");
		
		String userInput = scanner.nextLine();
		userInput = scanner.nextLine();
		while(userInput.isEmpty()){
			currentCycle++;
			machine.executeCycle(currentCycle);
			System.out.println("\nCycle number: " + currentCycle);
			System.out.println("\n" + machine.displayMachine());
			userInput = scanner.nextLine();
		}
		
		scanner.close();
	}

}
