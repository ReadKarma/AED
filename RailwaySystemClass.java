import dataStructures.List;
import dataStructures.DoubleList;
import dataStructures.Iterator;
import dataStructures.TwoWayIterator;

//TO DO: IMPLEMENT QUEUE AND LINECOUNTER
//TO DO: ALL METHODS

//manages lines, train schedules and stations
public class RailwaySystemClass implements RailwaySystem {
	
	private List<Line> lines;
	

    public RailwaySystemClass() //constructor
    {
    	lines = new DoubleList<Line>();
    }
    
    //A situação de erro ocorre caso uma linha com o mesmo nome já exista no sistema.
    public void addLine(String name, List<String> stations) throws ExistentLineException
    {
    	if(existsLine(name)) throw new ExistentLineException();
    	
    	Line line = new LineClass(name, stations);
    	lines.addLast(line);
    }

    //Todas as estações da linha que não pertençam a outra linha serão eliminadas
    //A situação de erro aplica-se quando a linha não existe no sistema.
    public void removeLine(String name) throws InexistentLineException
    {

    	Iterator<Line> it = lines.iterator();
    	if(!existsLine(name)) throw new InexistentLineException();
    	while(it.hasNext())
    	{
    		Line current = it.next();
    		if(current.getName().equals(name)) lines.remove(current);
    	}
    }

    //returns an iterator of the stations of a given line
    public Iterator<String> checkLineStation(String name) throws InexistentLineException
    {
    	if(!existsLine(name)) throw new InexistentLineException();
    	Iterator<Line> it = lines.iterator();
    	Iterator<String> itit = null;
    	
    	while(it.hasNext())
    	{
    		Line current = it.next();
    		if(current.getName().equals(name))
    			{
    	    		List<String> stations = current.getStations();
    	    		itit = stations.iterator();
    	    		break;
    			}
    	}
    	return itit;
    }
    
    public void addTimeTable(String name, int trainNumber, List<String> timeTable) throws InexistentLineException, InvalidTimeTableException
    {
    	if(!existsLine(name)) throw new InexistentLineException();
    	//to do invalidtimetableexception verification
    	
    	List<String> line = getStations(name);
    	List<String> stationNames = new DoubleList<String>();
    	List<String> times = new DoubleList<String>();
    	Iterator<String> it = timeTable.iterator();
    	
    	while(it.hasNext()) 
    	{
         	String[] lineArray = it.next().split(" ");
         	String time = lineArray[lineArray.length - 1];
         	String sNames = "";
         	for(int i = 0; i < (lineArray.length - 1); i++) 
         	{
             	sNames.concat(lineArray[i]);
             	if(i < (lineArray.length - 2)) sNames.concat(" ");
         	}
         	times.addLast(time);
         	stationNames.addLast(sNames);
    	}
    	stationNames.find(name);
    	
    	if( !line.getFirst().equals(stationNames.getFirst()) || !line.getLast().equals(stationNames.getFirst())) throw new InvalidTimeTableException();
    	
    	Iterator<String> itTime = times.iterator(); //ordem crescente
    	String lastTime = it.next();
    	
    	while (itTime.hasNext())
    	{
    		
    		String currentTime = it.next();
    		if(!checkTime(lastTime, currentTime)) throw new InvalidTimeTableException();
    		
    		lastTime = currentTime;
    	}
    	
    	Iterator<String> itStation = stationNames.iterator();
    	TwoWayIterator<String> itLine = (TwoWayIterator)line.iterator();
    	String current = itStation.next();
    	boolean aux = current.equals(line.getLast());
    	
    	if(aux)
    	{
    		itLine.fullForward();
    	}
    	while(aux ? itLine.hasPrevious(): itLine.hasNext())
    	{
    		String var = aux ? itLine.previous(): itLine.next();
    		if(!itStation.hasNext()) break;
    		if(current.equals(var)) current = itStation.next();
    	}
    	if(itStation.hasNext()) throw new InvalidTimeTableException();
    	
    	//TrainSchedule timeTable = new TrainScheduleClass(lines.get(name) trainNumber);
    	//TO DO: get Line by name method
    	
    }

    public boolean existsLine(String name)
    {
    	Iterator<Line> it = lines.iterator();
    	while(it.hasNext())
    	{
    		Line current = it.next();
    		if(current.getName().equals(name)) return true; 
    	}
 
        return false;
    }

    //---------------AUX METHODS-----------------


    private List<String> getStations(String name)
    {
    	Iterator<Line> it = lines.iterator();
    	while(it.hasNext())
    	{
    		Line current = it.next();
    		if(current.getName().equals(name)) return current.getStations();
    	}
		return null;
    }
    
    //returns true is time2 > time1
    private static boolean checkTime(String time1, String time2) 
    {
    	String[] t1 = time1.split(":");
    	String[] t2 = time2.split(":");
    	
    	int h1 = Integer.parseInt(t1[0]);
    	int h2 = Integer.parseInt(t2[0]);
    	
    	if(h2 > h1) return true;
    	if(h2 < h1) return false;
    	else
    	{
    		int m1 = Integer.parseInt(t1[1]);
    		int m2 = Integer.parseInt(t2[1]);
        	if(m2 > m1) return true;
        	if(m2 < m1) return false;
    	}
    	
		return false;
    }
    

}
