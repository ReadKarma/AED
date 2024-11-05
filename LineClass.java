//railway line with stations
public class LineClass implements Line {
    
    //variables
    private String name;
    private List<StationClass> stations;
    //timetables (hash map?)

    public LineClass(String name, List<StationClass> stations)
    {
        this.name = name;
        this.stations = stations;
    }

    public String getName()
    {
        return name;
    }

    public List<StationClass> getStations()
    {
        return stations;
    }
}
