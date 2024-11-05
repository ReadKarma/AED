import java.util.Scanner;

/**
* @author João Pereirinha 64382 j.pereirinha@fct.campus.unl.pt
* @author Miguel Silva 68510 masa.silva@campus.fct.unl.pt
*/

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
    public static final String IL_FAIL = "Linha existente."; // Inserção de linha com sucesso
    public static final String RL_SUCESS = "Remoção de linha com sucesso."; // Remoção de linha com sucesso

    public static void main(String[] args) {

        //variables
        Scanner in = new Scanner(System.in);
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
                case ADD_TIMETABLE         -> {}
                case REMOVE_TIMETABLE      -> {}
                case CHECK_LINE_TIMETABLES -> {}
                //case STATION_TRAINS        -> {} //fase 2
                case BEST_COURSE           -> {}
                case QUIT                  -> System.out.println(QUIT_MESSAGE);
                default                    -> System.out.println(COMMAND_ERROR);
            }
        }
        while(!command.equals(QUIT));


        in.close();
    }

    /**
	* Retrieves the next command from the user.
	* @param in Scanner object to read user input.
	* @return The next command entered by the user, in uppercase.
	**/
    private static String getCommand(Scanner in)
    {
		String input;
		
		input = in.nextLine().toUpperCase();
		return input;
	}

    /**
	* Retrieves the next command from the user.
	* @param in Scanner object to read user input.
    * @param railway RailwaySystemClass object to manage railway system
	**/
    private static void insertLine(Scanner in, RailwaySystemClass railway)
    {

        //variables
        String lineName = in.nextLine().trim(); //read line name
        String[] station = new String[500];
        int stationCounter = 0; //number of stations in this array

        while(in.hasNextLine()) //reads stations 
        {
            station[stationCounter] = in.nextLine().trim();

            if(station[stationCounter].isEmpty()) break;
            stationCounter++;
        }

        String[] stationArgument = new String[stationCounter]; //array to pass as argument
        System.arraycopy(station, 0, stationArgument, 0, stationCounter);

        if(railway.addLine(lineName, stationArgument)) System.out.println(IL_SUCESS); //sucess
        else System.out.println(IL_FAIL); //fail

    }

    /**
	* removes an existing line
	* @param in Scanner object to read user input.
    * @param railway RailwaySystemClass object to manage railway system
	**/
    private static void removeLine(Scanner in, RailwaySystemClass railway)
    {
        String lineName = in.nextLine().trim(); //read line name
    
        if(railway.removeLine(lineName)) System.out.println(RL_SUCESS); //sucess
        else System.out.println(LINE_NO_EXIST); //fail
    }
    
    /**
	* prints the stations in a given line
	* @param in Scanner object to read user input.
    * @param railway RailwaySystemClass object to manage railway system
	**/
    private static void checkLineStations(Scanner in, RailwaySystemClass railway){

        String lineName = in.nextLine().trim(); //read line name

        if(!railway.checkLineStation(lineName)) System.out.println(LINE_NO_EXIST); //fail
    }

}


