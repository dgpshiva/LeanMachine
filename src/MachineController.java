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
		
		
		
		System.out.println("\n\n" + machine.displayMachine());
		//System.out.println("Lean machine throughput: " + machine.getLoad());
		
		while(true){
			
			
			System.out.println("Cycle number: " + currentCycle);
			System.out.println("\n\n" + machine.displayMachine());
			currentCycle++;
			scanner.nextLine();
		}
		
		//scanner.close();
	}

}
