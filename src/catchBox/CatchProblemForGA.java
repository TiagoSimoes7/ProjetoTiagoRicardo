package catchBox;

import com.sun.corba.se.impl.corba.EnvironmentImpl;
import ga.Problem;
import org.omg.CORBA.Environment;


import java.util.LinkedList;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    //TODO this class might require the definition of additional methods and/or attributes

    private int GENOME_SIZE;

    private LinkedList<Cell> cellsBoxes;
    private LinkedList<Pair> pairs;
    private Cell cellCatch;
    private Cell door;

    public CatchProblemForGA(LinkedList<Cell> cellsBoxes, LinkedList<Pair> pairs, Cell cellCatch, Cell door) {

        this.cellsBoxes = cellsBoxes;
        this.pairs = pairs;
        this.cellCatch = cellCatch;
        this.door = door;
    }

    @Override
    public CatchIndividual getNewIndividual() {

        GENOME_SIZE = cellsBoxes.size();
        
        return new CatchIndividual(this, GENOME_SIZE);
    }

    public LinkedList<Cell> getCellsBoxes() {
        return cellsBoxes;
    }

    public LinkedList<Pair> getPairs() {
        return pairs;
    }

    public Cell getCellCatch() {
        return cellCatch;
    }

    public Cell getDoor() {
        return door;
    }

    @Override
    public String toString() {
        //TODO
        return ("Não implementado ainda");
    }
}
