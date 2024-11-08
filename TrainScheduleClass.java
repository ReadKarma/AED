import dataStructures.List;
//train schedule, depart and arrival time at each station in a line
public class TrainScheduleClass implements TrainSchedule {
    
    private Line line;
    private int trainNumber;
    private String firstStation;
    private String startTime;
    private List<String[]> schedule;

    public TrainScheduleClass(Line line, int trainNumber, List<String[]> schedule)
    {
        this.line = line;
        this.trainNumber = trainNumber;
        this.schedule = schedule;
        this.firstStation = this.setFirstStation(schedule);
        this.startTime = this.setStartTime();
    }
    
    private String setFirstStation(List<String[]> schedule)
    {
    	String[] aux = schedule.getFirst();    	
    	return aux[0];
    }
    
    private String setStartTime()
    {
    	String[] aux = schedule.getFirst();
    	return aux[1];
    }
    
    public Line getLine()
    {
    	
    	return line;
    }
    
    public int getTrainNumber()
    {
    	return trainNumber;
    }
    
    public String getFirstStation()
    {
    	return firstStation;
    }
    public String getStartTime()
    {
    	return startTime;
    }
    
    public List<String[]> getSchedule()
    {
    	return schedule;
    }
    

    
}
