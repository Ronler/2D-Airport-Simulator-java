
public class WaitLine
{
	private Object[] queue;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT = 5;
	
	public WaitLine()
	{
		this(DEFAULT);
	}
	
	public WaitLine(int initialCapacity)
	{
		Object[] tempQueue = (Object[]) new Object[initialCapacity+1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
	}
	
	public void enqueue(Object entry)
	{
		backIndex = (backIndex+1) % queue.length;
		queue[backIndex] =entry;
	}
	
	public Object dequeue()
	{
		Object front = null;
		
		if(!isEmpty())
		{
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
		}
		
		return front;
	}
	
	public void clear()
	{
		while(!isEmpty())
			dequeue();
	}
	
	public boolean isEmpty()
	{
		return frontIndex == ((backIndex + 1) % queue.length);
	}
	
	public void display()
	{
		for (int index = 0; index < backIndex + 1; index++)
		{
			if(queue[index] == null)
				index++;
			
			System.out.println(queue[index]);
		}
	}
	
	public Object getFront() 
	{
		Object front = null;
		
		if(!isEmpty())
		{
			front = queue[frontIndex];
		}
		return front;
	}
}
