package catchBox;

import agentSearch.Action;
import agentSearch.State;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CatchState extends State implements Cloneable {
    //TODO this class might require the definition of additional methods and/or attributes

    protected int[][] matrix;
    private int lineCatch;
    private int columnCatch;

    public CatchState(int[][] matrix) {
        this.matrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (this.matrix[i][j] == 0) {
                    lineCatch = i;
                    columnCatch = j;
                }
            }
        }
    }

    public CatchState(int[][] matrix, int lineCatch, int columnCatch) {
        this.matrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        this.lineCatch = lineCatch;
        this.columnCatch = columnCatch;
    }

    public double compute(int lineGoal, int columnGoal){
        return Math.abs(lineCatch-lineGoal) + Math.abs(columnCatch-columnGoal);
    }

    public void executeAction(Action action) {
        action.execute(this);
        // TODO
        fireUpdatedEnvironment();

        throw new UnsupportedOperationException("Não implementado ainda"); // delete after implementing
    }

    public boolean canMoveUp() {
        return lineCatch != 0 && matrix[lineCatch-1][columnCatch] != Properties.WALL;
    }

    public boolean canMoveRight() {
        return columnCatch != matrix.length - 1 && matrix[lineCatch][columnCatch+1] != Properties.WALL;
    }

    public boolean canMoveDown() {
        return lineCatch != matrix.length - 1 && matrix[lineCatch+1][columnCatch] != Properties.WALL;
    }

    public boolean canMoveLeft() {
        return columnCatch != 0 && matrix[lineCatch][columnCatch-1] != Properties.WALL;
    }

    public void moveUp() {
        matrix[lineCatch][columnCatch] = Properties.EMPTY;
        matrix[--lineCatch][columnCatch] = Properties.CATCH;
    }

    public void moveRight() {
        matrix[lineCatch][columnCatch] = Properties.EMPTY;
        matrix[lineCatch][++columnCatch] = Properties.CATCH;
    }

    public void moveDown() {
        matrix[lineCatch][columnCatch] = Properties.EMPTY;
        matrix[++lineCatch][columnCatch] = Properties.CATCH;
    }

    public void moveLeft() {
        matrix[lineCatch][columnCatch] = Properties.EMPTY;
        matrix[lineCatch][--columnCatch] = Properties.CATCH;
    }

    public int getNumBox() {    //num boxes apanhadas
        //TODO
        //return numBoxes;
        return 0;
    }

    public void setCellCatch(int line, int column) {
        matrix[lineCatch][columnCatch] = Properties.EMPTY;
        lineCatch = line;
        columnCatch = column;
        matrix[lineCatch][columnCatch] = Properties.CATCH;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getSteps() {
        //TODO
        return 0; //se estiver a dar problemas
    }

    public int getSize() {
        return matrix.length;
    }

    public Color getCellColor(int line, int column) {
        switch (matrix[line][column]) {
            case Properties.BOX:
                return Properties.COLORBOX;
            case Properties.CATCH:
                return Properties.COLORCATCH;
            case Properties.DOOR:
                return Properties.COLORDOOR;
            case Properties.WALL:
                return Properties.COLORWALL;
            default:
                return Properties.COLOREMPTY;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CatchState)) {
            return false;
        }

        CatchState o = (CatchState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public CatchState clone() {
        return new CatchState(matrix, lineCatch, columnCatch);
    }

    //Listeners
    private final ArrayList<EnvironmentListener> listeners = new ArrayList<>();

    public synchronized void addEnvironmentListener(EnvironmentListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public synchronized void removeEnvironmentListener(EnvironmentListener l) {
        listeners.remove(l);
    }

    public void fireUpdatedEnvironment() {
        for (EnvironmentListener listener : listeners) {
            listener.environmentUpdated();
        }
    }

    public int getLineCatch() {
        return lineCatch;
    }

    public int getColumnCatch() {
        return columnCatch;
    }
}
