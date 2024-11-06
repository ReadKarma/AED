import dataStructures.List;

//railway line with stations
public class LineClass implements Line {
    
    //variables
    private String name;
    private List<String> stations;
    //timetables (hash map?)

    public LineClass(String name, List<String> stations)
    {
        this.name = name;
        this.stations = stations;
    }

    public String getName()
    {
        return name;
    }

    public List<String> getStations()
    {
        return stations;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
    	return ((LineClass)obj).getName().equals(name);
    }
    
}
