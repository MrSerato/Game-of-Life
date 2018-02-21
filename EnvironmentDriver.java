package gameOfLife;

public class EnvironmentDriver {
	
	public static void main(String[] args){
		
		String filename = "GameOfLife2.txt";
		Environment e = new Environment(filename);
		System.out.println("This cell has: " + e.getNeighbors(0, 4));
		
		
		boolean test = true;
		e.setCanvas();
		while(test)
		{
			e.runSimulation();
		}
		
	}

}

