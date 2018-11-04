package solution;

import problem.ProblemSpec;

import java.io.IOException;

public class Solver {

    public static void main(String[] args) {

        ProblemSpec ps;
        try {
            String inputFile = args[0];
            String outputFile = args[1];
            ps = new ProblemSpec("examples/level_1/" + inputFile);
            MDPSolver mdpSolver = new MDPSolver(ps);
            mdpSolver.solve(outputFile);
            System.out.println(ps.toString());
        } catch (IOException e) {
            System.out.println("IO Exception occurred");
            System.exit(1);
        }
        System.out.println("Finished loading!");
    }
}
