import org.junit.Test;
import static org.junit.Assert.*;


public class BlockIT {
	
	@Test
	public void machineTest() {
		Machine machine = new Machine();
		machine.addBlock(45);
		machine.addBlock(40);
		machine.addBlock(30);
		String result = "Block number: 0\nCapacity: 45\n\nBlock number: 1\nCapacity: 40\nQueue size: 0\n\nBlock number: 2\nCapacity: 30\nQueue size: 0\n\n";
		assertEquals(result, machine.displayMachine());
	}
}
