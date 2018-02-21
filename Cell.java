package gameOfLife;

public class Cell {
	
	private boolean occupied;
	
	public Cell(boolean o){
		occupied = o;
	}
	
	public boolean getOccupied(){
		return occupied;
	}

}
