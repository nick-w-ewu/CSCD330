import java.io.Serializable;

public class CellRecord implements Serializable
{
	private int startTime;
	private int endTime;
	private int totalTime;
	private String id;
	private static final long serialVersionUID = 1L;
	
	public CellRecord(int stime, int etime, String id)
	{
		this.startTime = stime;
		this.endTime = etime;
		this.id = id;
		this.totalTime = 0;
	}
	
	public String getID()
	{
		return this.id;
	}

	public int getStartTime()
	{
		return startTime;
	}

	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}

	public int getEndTime()
	{
		return endTime;
	}

	public void setEndTime(int endTime)
	{
		this.endTime = endTime;
	}

	public int getTotalTime()
	{
		return totalTime;
	}

	public void setTotalTime(int totalTime)
	{
		this.totalTime = totalTime;
	}
	
	public void incrementTotalTime(int toAdd)
	{
		this.totalTime+=toAdd;
	}
	
	public void printRecord()
	{
		double cost = this.totalTime * .5;
		System.out.println(this.id + " Spoke for " + this.totalTime + " minuets total the charge is $" + cost);
	}
}
