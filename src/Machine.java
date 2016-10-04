import java.util.*;

import javax.crypto.Mac;

public class Machine {

	private List<Block> blocks;
	int load;
	int throughPut;
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

	int totalOutput;
	
	
	public int getLoad() {
		return load;
	}


	public void setLoad(int load) {
		this.load = load;
	}
	
	public Machine() {
		this.blocks = new ArrayList<Block>();
		throughPut = 0;
		totalOutput = 0;
	}


	public List<Block> getBlocks() {
		return blocks;
	}

	public void addBlock(int capacity) {
		blocks.add(new Block(capacity));
		//Block block = new Block(capacity);
	/*	if (blocks.size() > 1)
		{
			int diff = getBlocks().get(getBlocks().size() - 1).getCapacity() - capacity;
			if(diff < 0)
				diff = 0;
				
			block.setDiffWithPrevCapacity(diff);
		}*/
		//blocks.add(block);
	}

	public String displayMachine() {
		StringBuilder display = new StringBuilder();
		for(int i = 0; i < blocks.size(); i++) {
			display.append("Block number: " + i + "\n");
			display.append("Capacity: " + blocks.get(i).getCapacity() + "\n");
			if(i != 0) display.append("Queue size: " + blocks.get(i).getQueueSize() + "\n");
			display.append("\n");
		}
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
			setThroughPut(0);
			setTotalOutput(0);
			
			if (cycleCount == blocks.size() - 1)
			{
				for (int i =1 ; i < blocks.size(); i++)
				{
					blocks.get(i).setInitialQueueSize(blocks.get(i).getQueueSize());
				}
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
