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

    //messages
    public static final String QUIT_MESSAGE = "Aplicação terminada."; //Terminar aplicação
    public static final String COMMAND_ERROR = "."; //Terminar aplicação

    public static void main(String[] args) {

        //variables
        Scanner in = new Scanner(System.in);
        String command;

        //command interpreter
        do
        {
            command = getCommand(in);
            switch(command){
                case INSERT_LINE:

                    break;
                case REMOVE_LINE:

                    break;
                case CHECK_LINE:

                    break;
                case CHECK_STATION:

                    break;
                case ADD_TIMETABLE:

                    break;
                case REMOVE_TIMETABLE:

                    break;
                case CHECK_LINE_TIMETABLES:

                    break;
                case STATION_TRAINS:

                    break;
                case BEST_COURSE:

                    break;
                case QUIT:
                    System.out.println(QUIT_MESSAGE);
                    break;
                default:
                    System.out.println(COMMAND_ERROR);
                    break;

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
    private static String getCommand(Scanner in) {
		String input;
		
		input = in.nextLine().toUpperCase();
		return input;
	}
}


