package solution;

import problem.Action;
import problem.ProblemSpec;
import simulator.State;

import java.util.ArrayList;
import java.util.List;

public class MDPSolver {
    ProblemSpec problemSpec;

    int timeStamp;
    State currentState;

    List<Action> policy;

    MDPSolver(ProblemSpec problemSpecs){
        this.problemSpec = problemSpecs;
        policy = new ArrayList<>();

    }

    public void solve(String outputFile){
        valueIteration();
        WriteFile writeFile = new WriteFile(outputFile);
    }

    private void valueIteration() {

    }
}
