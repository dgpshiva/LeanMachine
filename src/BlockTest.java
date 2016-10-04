
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BlockTest {

	@Test
	public void createNode() 
	{
		Block block = new Block(25);
		assertEquals(25, block.getCapacity());
		assertEquals(0, block.getQueueSize());
	}
}
