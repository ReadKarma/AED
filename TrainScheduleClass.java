
//train schedule, depart and arrival time at each station in a line
public class TrainScheduleClass implements TrainSchedule {
    
    String lineName;
    int trainNumber;

    public TrainScheduleClass(String lineName, int trainNumber ) //add hh:mm (station & time list)
    {
        this.lineName = lineName;
        this.trainNumber = trainNumber;
    }

}
