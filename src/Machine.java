import java.util.*;

import javax.crypto.Mac;

public class Machine {

	private List<Block> blocks;
	int load;
	int throughPut;
	int totalOutput;
	
	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}
	
	public int getLoad() {
		return load;
	}

	public void setLoad(int load) {
		this.load = load;
	}
	
	public int getThroughPut() {
		return throughPut;
	}

	public void setThroughPut(int throughPut) {
		this.throughPut = throughPut;
	}

	public int getTotalOutput() {
		return totalOutput;
	}
	
	public void setTotalOutput(int totalOutput) {
		this.totalOutput = totalOutput;
	}
	
	public Machine() {
		this.blocks = new ArrayList<Block>();
		throughPut = 0;
		totalOutput = 0;
	}

	public void addBlock(int capacity) {
		blocks.add(new Block(capacity));
	}

	public String displayMachine() {
		StringBuilder display = new StringBuilder();
		for(int i = 0; i < blocks.size(); i++) {
			display.append("Block number: " + (int)i+1 + "\n");
			display.append("Capacity: " + blocks.get(i).getCapacity() + "\n");
			if(i != 0) display.append("Queue size: " + blocks.get(i).getQueueSize() + "\n");
			display.append("\n");
		}
		display.append("Throughput: " + getThroughPut());
		display.append("\nTotal output: " + getTotalOutput());
		
		int totalInQueue = 0;
		for (int i=0; i<blocks.size(); i++)
			totalInQueue += blocks.get(i).getQueueSize();
		display.append("\nTotal waiting in system: " + totalInQueue);
		
		display.append("\n");
		return display.toString();
	}

	public void calculateQueueSize(int cycle) {
		int newQueSize = 0;
		if (load - blocks.get(cycle).getCapacity() > 0)
		{
			newQueSize = blocks.get(cycle).getQueueSize() + (load - blocks.get(cycle).getCapacity());
			blocks.get(cycle).setQueueSize(newQueSize);
		}
		this.load = Math.min(load,  blocks.get(cycle).getCapacity());
	}
	
	public void executeCycle(int cycleCount)
	{
		if (cycleCount == 0)
		{
			setLoad(blocks.get(0).getCapacity());
			setThroughPut(0);
			setTotalOutput(0);			
		}
		else if (cycleCount < blocks.size())
		{
			calculateQueueSize(cycleCount);
			blocks.get(cycleCount).setInitialQueueSize(blocks.get(cycleCount).getQueueSize());
			for (int i=1; i<cycleCount; i++)
			{
				blocks.get(i).setQueueSize(blocks.get(i).getQueueSize() + blocks.get(i).getInitialQueueSize());
			}
			setThroughPut(0);
			setTotalOutput(0);
			
			if (cycleCount == blocks.size() - 1)
			{
		/*		for (int i =1 ; i < blocks.size(); i++)
				{
					blocks.get(i).setInitialQueueSize(blocks.get(i).getQueueSize());
				}*/
				setThroughPut(getLoad());
				setTotalOutput(getThroughPut());
			}
		}
		else
		{
			for (int i = 1; i < blocks.size(); i++)
				blocks.get(i).setQueueSize(blocks.get(i).getQueueSize() + blocks.get(i).getInitialQueueSize());
					
			setThroughPut(getLoad());
			setTotalOutput(getTotalOutput() + getThroughPut());

		}		
	}
}
