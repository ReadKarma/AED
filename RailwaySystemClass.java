
//TO DO: IMPLEMENT QUEUE AND LINECOUNTER
//TO DO: ALL METHODS

//manages lines, train schedules and stations
public class RailwaySystemClass implements RailwaySystem {

    public RailwaySystemClass() //constructor
    {

    }
    
    //A situação de erro ocorre caso uma linha com o mesmo nome já exista no sistema.
    public boolean addLine(String name, String[] stations) 
    {

        return false; //TO DO
    }

    //Todas as estações da linha que não pertençam a outra linha serão eliminadas
    //A situação de erro aplica-se quando a linha não existe no sistema.
    public boolean removeLine(String name)
    {

        //TO DO: remove line function
        return existsLine(name);
    }

    public boolean checkLineStation(String name)
    {
        //if(existsLine()) 
            //printline(name);
            //return true
        //else return false
        return existsLine(name);
    }

    public boolean existsLine(String name)
    {
        return true;
    }

    //---------------AUX METHODS-----------------


    private static void printLine(String name)
    {

    }

}
