package work;
import java.util.ArrayList;

public class State {
	private final int cell;
	private double reward;
	private double currentValue;
	private double previousValue;
	private ArrayList<Action> allActions;
	private boolean[] actionTaken = new boolean[8];
	private Action bestAction;
	
	public double qS; //q-learning value
	private boolean visited;
	private int numVisited;
	private boolean terminate;
	
	public State(int cell) {
		this.cell = cell;
		reward = 0;
		currentValue = 0;
		previousValue = 0;
		allActions = new ArrayList<Action>();
		bestAction = null;
		visited = false;
		terminate = false;
		qS = 0;
		for (int i = 0; i < 8; i++) {
			actionTaken[i] = false;
		}
		numVisited = 0;
	}
	
	public State(int cell, double reward, double currentValue) {
		this.cell = cell;
		this.reward = reward;
		this.currentValue = currentValue;
		previousValue = 0;
		allActions = new ArrayList<Action>();
		bestAction = null;
		visited = false;
		terminate = false;
		qS = 0;
		for (int i = 0; i < 8; i++) {
			actionTaken[i] = false;
		}
		numVisited = 0;
	}
	
	public double getReward() {
		return reward;
	}
	
	public double getDiff() {
		return currentValue - previousValue;
	}
	
	public void incrementVisit() {
		numVisited++;
	}
	
	
	public ArrayList<Action> getActions() {
		return allActions;
	}
	public void addAction(Action a) {
		allActions.add(a);
		if (bestAction == null) {
			bestAction = a;
		}
	}
	
	public double getPreValue() {
		return previousValue;
	}
	
	public void setPreValue(double v) {
		this.previousValue = v;
	}
	
	public double getCurValue() {
		return currentValue;
	}
	
	public void setCurValue(double v) {
		this.currentValue = v;
	}
	
	public void setReward(double r) {
		reward = r;
	}
	
	public int getCell() {
		return cell;
	}
	
	public boolean isTerminate() {
		return terminate;
	}
	
	public void setTerminate() {
		this.terminate = true;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean equals(Object s){
		if((s != null) && (s instanceof State)){
			if(((State)s).cell == this.cell)
				return true;
			else
				return false;
		}
		return false;
	}
}
