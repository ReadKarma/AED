import dataStructures.List;

public interface Line {
	
	public String getName();
	
	public List<String> getStations();

	public void addTrainSchedule(TrainScheduleClass newSchedule);
	
	public List<TrainScheduleClass> getTrainInThisLine();
}
