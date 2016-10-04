
public class Block {
	int capacity;
	int queueSize;
	int initialQueueSize;
	
	public Block(int capacity) {
		this.capacity = capacity;
		this.queueSize = 0;
		this.initialQueueSize = 0;
	}

	public int getInitialQueueSize() {
		return initialQueueSize;
	}

	public void setInitialQueueSize(int initialQueueSize) {
		this.initialQueueSize = initialQueueSize;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getQueueSize() {
		return queueSize;
	}
	
	public void setQueueSize(int queueSize) {
		this.queueSize = queueSize;
	}

}
