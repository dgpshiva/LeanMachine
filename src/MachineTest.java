import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MachineTest {
	@Test
	public void createNullMachine()
	{
		Machine machine = new Machine();		
		assertEquals(new ArrayList<Block>(), machine.getBlocks());
	}
	
	@Test
	public void createMachineWithTwoBlocks()
	{
		Machine machine = new Machine();
		machine.addBlock(10);
		machine.addBlock(40);
		assertEquals(2, machine.getBlocks().size());
		assertEquals(10, machine.getBlocks().get(0).getCapacity());
		assertEquals(40, machine.getBlocks().get(1).getCapacity());
	}
	
	@Test
	public void displayEmptyMachine()
	{
		Machine machine = new Machine();
		assertEquals("", machine.displayMachine());
	}
	
	@Test
	public void displayMachineWithTwoBlocks()
	{
		Machine machine = new Machine();
		machine.addBlock(40);
		machine.addBlock(10);
		String result = "Block number: 0\nCapacity: 40\n\nBlock number: 1\nCapacity: 10\nQueue size: 0\n\n";
		assertEquals(result, machine.displayMachine());
	}
	
	@Test
	public void getQueueSizeBlocks1()
	{
		Machine machine = new Machine();
		machine.addBlock(100);
		machine.addBlock(40);
		machine.setLoad(100);
		machine.calculateQueueSize(0);
		machine.calculateQueueSize(1);
		assertEquals(0, machine.getBlocks().get(0).getQueueSize());
		assertEquals(60, machine.getBlocks().get(1).getQueueSize());
	}
	
	@Test
	public void getQueueSizeBlock2()
	{
		Machine machine = new Machine();
		machine.addBlock(40);
		machine.addBlock(100);
		machine.setLoad(40);
		machine.calculateQueueSize(0);
		machine.calculateQueueSize(1);
		assertEquals(0, machine.getBlocks().get(0).getQueueSize());
		assertEquals(0, machine.getBlocks().get(1).getQueueSize());
	}
	
	@Test
	public void getQueSizeComplex()
	{
		Machine machine = new Machine();
		machine.addBlock(50);
		machine.addBlock(60);
		machine.addBlock(55);
		machine.addBlock(40);
		
		machine.setLoad(50);
		
		for (int i=0; i<4; i++)
		{
			machine.calculateQueueSize(i);
		}
		
		assertEquals(10, machine.getBlocks().get(3).getQueueSize());
	}
	
	@Test
	public void executeCycleTwoTimes()
	{
		Machine machine = new Machine();
		machine.addBlock(50);
		machine.addBlock(60);
		machine.addBlock(55);
		machine.addBlock(40);
		
		machine.executeCycle(2);		
		for (int i=0; i < 4; i++)
		{
			assertEquals(0, machine.getBlocks().get(i).getQueueSize());
		}
		assertEquals(0, machine.getThroughPut());
		assertEquals(0, machine.getTotalOutput());
	}
	
	@Test
	public void executeCycleFourTimes()
	{
		Machine machine = new Machine();
		machine.addBlock(50);
		machine.addBlock(60);
		machine.addBlock(55);
		machine.addBlock(40);
		
		for (int i=0; i < 4; i++)
		{
			machine.executeCycle(i);
		}
		
		for (int i=0; i < 3; i++)
		{
			assertEquals(0, machine.getBlocks().get(i).getQueueSize());
		}
		
		assertEquals(10, machine.getBlocks().get(3).getQueueSize());
		assertEquals(40, machine.getThroughPut());
		assertEquals(40, machine.getTotalOutput());
	}
	
	@Test
	public void executeCycleSixTimes()
	{
		Machine machine = new Machine();
		machine.addBlock(50);
		machine.addBlock(60);
		machine.addBlock(55);
		machine.addBlock(40);
		
		for (int i = 0; i < 6; i++)
		{
			machine.executeCycle(i);
		}
		
		for (int i=0; i < 3; i++)
		{
			assertEquals(0, machine.getBlocks().get(i).getQueueSize());
		}
		
		assertEquals(30, machine.getBlocks().get(3).getQueueSize());
		assertEquals(40, machine.getThroughPut());
		assertEquals(120, machine.getTotalOutput());

	}
	
}
