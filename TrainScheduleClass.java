
//train schedule, depart and arrival time at each station in a line
public class TrainScheduleClass implements TrainSchedule {
    
    private Line line;
    private int trainNumber;

    public TrainScheduleClass(Line line, int trainNumber)
    {
        this.line = line;
        this.trainNumber = trainNumber;
    }
    
    public Line getLine()
    {
    	
    	return line;
    }
    
    public int getTrainNumber()
    {
    	return trainNumber;
    }
    

    
}
