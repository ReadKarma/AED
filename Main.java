import java.util.Scanner;
import dataStructures.List;
import dataStructures.DoubleList;
import dataStructures.Iterator;

/**
* @author João Pereirinha 64382 j.pereirinha@fct.campus.unl.pt
* @author Miguel Silva 68510 masa.silva@campus.fct.unl.pt
*/

//perguntar: podemos usar System.arraycopy
public class Main{

    //CONSTANTS
    //commands:
    public static final String INSERT_LINE = "IL"; //Inserção de linha
    public static final String REMOVE_LINE = "RL"; //Remoção de linha
    public static final String CHECK_LINE = "CL"; //Consulta das estações de uma linha
    public static final String CHECK_STATION = "CE"; //Consulta das linhas de uma estação
    public static final String ADD_TIMETABLE = "IH"; //inserção de horário
    public static final String REMOVE_TIMETABLE = "RH"; //Remoção de horário
    public static final String CHECK_LINE_TIMETABLES = "CH"; //Consulta dos horários de uma linha
    public static final String STATION_TRAINS = "LC"; //Comboios por estação
    public static final String BEST_COURSE = "MH"; //Melhor Horário
    public static final String QUIT = "TA"; //Terminar aplicação

    //messages:
    public static final String QUIT_MESSAGE = "Aplicação terminada."; //Terminar aplicação
    public static final String COMMAND_ERROR = "?????????????????"; //erro
    public static final String LINE_NO_EXIST = "Linha inexistente."; // Inserção de linha sem sucesso
    public static final String IL_SUCESS = "Inserção de linha com sucesso."; // Inserção de linha com sucesso
    public static final String IL_FAIL = "Linha existente."; // 
    public static final String RL_SUCESS = "Remoção de linha com sucesso."; // 
    public static final String INVALID_SCHEDULE = "Horário inválido";
    public static final String IH_SUCESS = "Criação de horário com sucesso.";
    public static final String RH_SUCESS = "Remoção de horário com sucesso.";
    public static final String SCHEDULE_NO_EXIST = "Horário inexistente.";
    public static final String FIRST_STATION_NO_EXIST = "Estação de partida inexistente.";
    
    public static void main(String[] args) {

        //variables
        try (Scanner in = new Scanner(System.in)) {
            RailwaySystemClass railway = new RailwaySystemClass();
            String command;
            
            //command interpreter
            do
            {
                command = getCommand(in);
                switch(command){
                    
                    case INSERT_LINE           -> insertLine(in, railway);
                    case REMOVE_LINE           -> removeLine(in, railway);
                    case CHECK_LINE            -> checkLineStations(in, railway);
                    //case CHECK_STATION         -> {} //fase 2
                    case ADD_TIMETABLE         -> addTimeTable(in, railway);
                    case REMOVE_TIMETABLE      -> removeTimeTable(in, railway);
                    case CHECK_LINE_TIMETABLES -> checkLineSchedules(in, railway);
                    //case STATION_TRAINS        -> {} //fase 2
                    case BEST_COURSE           -> {}
                    case QUIT                  -> System.out.println(QUIT_MESSAGE);
                    default                    -> System.out.println(COMMAND_ERROR);
                }
            }
            while(!command.equals(QUIT));
        }
    }

    /**
	* Retrieves the next command from the user.
	* @param in Scanner object to read user input.
	* @return The next command entered by the user, in uppercase.
	**/
    private static String getCommand(Scanner in)
    {
		String input;
		
		input = in.next().toUpperCase();
		return input;
	}

    /**
	* adds a new line to the system
	* @param in Scanner object to read user input.
    * @param railway RailwaySystemClass object to manage railway system
	**/
    private static void insertLine(Scanner in, RailwaySystemClass railway)
    {
    	
        //variables
        String lineName = in.nextLine().trim(); //line name
        List<String> station = new DoubleList<String>();

        while(in.hasNextLine()) //reads stations 
        {
        	String stationName = in.nextLine().trim();
        	if(stationName.equals("")) break;
            station.addLast(stationName);
        }

        try 
        {
        	railway.addLine(lineName, station);
        	System.out.println(IL_SUCESS);
        } catch(ExistentLineException e) 
        {
        	System.out.println(IL_FAIL);
        }

    }

    /**
	* removes an existing line
	* @param in Scanner object to read user input.
    * @param railway RailwaySystemClass object to manage railway system
	**/
    private static void removeLine(Scanner in, RailwaySystemClass railway)
    {
        String lineName = in.nextLine().trim(); //line name
    
        try
        {
        	railway.removeLine(lineName);
        	System.out.println(RL_SUCESS);
        }
        catch(InexistentLineException e)
        {
        	System.out.println(LINE_NO_EXIST);
        }
        
    }
    
    /**
	* prints the stations in a given line
	* @param in Scanner object to read user input.
    * @param railway RailwaySystemClass object to manage railway system
	**/
    private static void checkLineStations(Scanner in, RailwaySystemClass railway){

        String lineName = in.nextLine().trim(); //line name

        try
        { 
        	Iterator<String> it = railway.checkLineStation(lineName);
        	
        
        	while(it.hasNext()) System.out.println(it.next());	
        	
        }
        catch(InexistentLineException e)
        {
        	System.out.println(LINE_NO_EXIST);
        }
        
    }

    /**
	* adds a new train schedule to a given line
	* @param in Scanner object to read user input.
    * @param railway RailwaySystemClass object to manage railway system
	**/
    private static void addTimeTable(Scanner in, RailwaySystemClass railway)
    {
        String lineName = in.nextLine().trim(); //line name
        List<String> station = new DoubleList<String>();
        
        if(railway.existsLine(lineName)) System.out.println(LINE_NO_EXIST);

        int trainNumber = in.nextInt(); //train number
        in.nextLine();
        
        String line;
         while(in.hasNextLine())
         {
         	line = in.nextLine();
         	if(line.equals("")) break;
         	station.addLast(line);
         }

        try
        {
        	railway.addTimeTable(lineName, trainNumber, station);
        	System.out.println(IH_SUCESS);
        }
        catch(InexistentLineException e)
        {
        	System.out.println(LINE_NO_EXIST);
        }
        catch(InvalidTimeTableException ee)
        {
        	System.out.println(INVALID_SCHEDULE);
        }

    }
    
    private static void removeTimeTable(Scanner in, RailwaySystemClass railway)
    {
    	String lineName = in.nextLine().trim(); //line name
    	String line = in.nextLine(); // nome-estacao-partida hora-partida
    	
    	try
    	{
    		railway.removeSchedule(lineName, line);
    		System.out.println(RH_SUCESS);
    	}
    	catch(InexistentLineException e)
    	{
    		System.out.println(LINE_NO_EXIST);
    	}
    	catch(InexistentScheduleException r)
    	{
    		System.out.println(SCHEDULE_NO_EXIST);
    	}
    }
    
    private static void checkLineSchedules(Scanner in, RailwaySystemClass railway)
    {
    	String lineName = in.nextLine().trim(); //line name
    	String line = in.nextLine(); // nome-estacao-partida
    	
    	
    	try //SUCESS
    	{
    		List<TrainScheduleClass> trains = railway.checkLineSchedules(lineName, line);
    		Iterator<TrainScheduleClass> it = trains.iterator();
    		TrainScheduleClass current;
    		
    		
    		while(it.hasNext())
    		{
    			current = it.next();
    			System.out.println(current.getTrainNumber());
    			List<String[]> schedules = current.getSchedule();
    			
    			for(int i = 0; i < schedules.size(); i++)
    			{
    				String[] sch = schedules.get(i);
    				System.out.println(sch[0] + " " + sch[1]);
    			}
    			
    		}
    		
    		
    	}
    	catch(InexistentLineException e)
    	{
    		System.out.println(LINE_NO_EXIST);
    	}
    	catch(InexistentFirstStation r)
    	{
    		System.out.println(FIRST_STATION_NO_EXIST);
    	}
    }
    
}


