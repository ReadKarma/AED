import dataStructures.List;

public interface TrainSchedule {
    
	public Line getLine();
	
	public int getTrainNumber();
	
	public String getFirstStation();
	
	public String getStartTime();
	
	public List<String[]> getSchedule();

}
