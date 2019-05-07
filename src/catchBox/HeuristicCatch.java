package catchBox;

import agentSearch.Heuristic;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HeuristicCatch extends Heuristic<CatchProblemSearch, CatchState> {

    @Override
    public double compute(CatchState state) {
        return state.compute(problem.getGoalPosition().getLine(), problem.getGoalPosition().getColumn());
    }

    @Override
    public String toString() {
        return "Heuristica Calcula Distancias";
    }
}