package gameOfLife;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.princeton.cs.introcs.StdDraw;

public class Environment {
	private int rows;
	private int cols;
	private Cell[][] cells;
	Scanner input = null;

	public Environment(String filename) {

		try {
			System.out.println("Attempting to read file. . .");
			input = new Scanner(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File not found or could not be opened");
			System.exit(0);
		}
		rows = input.nextInt();
		cols = input.nextInt();
		cells = new Cell[rows][cols];

		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j < cols; j++) {
				if (input.nextInt() == 1) {
					cells[i][j] = new Cell(true);
				} else {
					cells[i][j] = new Cell(false);
				}
			}
		}

		System.out.println("=======INITIAL ENVIRONMENT=======");
		for (int i = cells.length - 1; i >= 0; i--) {
			for (int j = 0; j < cells[i].length; j++) {
				System.out.print("x" + j + "y" + i + cells[i][j].getOccupied() + "  ");
			}
			System.out.println();
		}

	}

	public void setCanvas() {
		int xSize = (this.rows) * 50;
		int ySize = (this.cols) * 50;
		StdDraw.setCanvasSize(xSize, ySize);
		StdDraw.setXscale(0, xSize);
		StdDraw.setYscale(0, ySize);

		int xInterval = xSize / (this.rows);
		int yInterval = ySize / (this.cols);

		System.out.println(xSize + " " + ySize + " X-Intervals are: " + xInterval + " Y-Intervals are: " + yInterval);
	}

	public void displayCells() {

		int xSize = (this.rows) * 50;
		int ySize = (this.cols) * 50;
		int xInterval = xSize / (this.rows);
		int yInterval = ySize / (this.cols);
		int radius = xSize / this.rows;
		int push = radius / 2;

		for (int i = this.cells.length - 1; i >= 0; i--) {
			for (int j = 0; j < this.cells[i].length; j++) {
				if (this.cells[i][j].getOccupied() == true) {
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledSquare(push + (j * yInterval), push + (i * xInterval), 20);

				}
			}
		}

	}

	public int getNeighbors(int y, int x) {
		int neighbors = 0;

		if (x == this.rows - 1) // top
		{
			if (y == this.cols - 1)// top right
			{
				if (this.cells[x - 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y - 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y - 1].getOccupied() == true) {
					neighbors++;
				}

			} else if (y == 0)// top left
			{
				if (this.cells[x - 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y + 1].getOccupied() == true) {
					neighbors++;
				}
			} else {
				if (this.cells[x - 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y - 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y - 1].getOccupied() == true) {
					neighbors++;
				}
			}
		}

		else if (x == 0) // bottom
		{
			if (y == this.cols - 1)// bottom right
			{
				if (this.cells[x + 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y - 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x + 1][y - 1].getOccupied() == true) {
					neighbors++;
				}
			} else if (y == 0)// bottom left
			{
				if (this.cells[x + 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x + 1][y + 1].getOccupied() == true) {
					neighbors++;
				}
			} else {
				if (this.cells[x + 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y - 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x + 1][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x + 1][y - 1].getOccupied() == true) {
					neighbors++;
				}
			}
		}

		else if (y == this.cols - 1) // right
		{
			if (x == this.rows - 1)// right top
			{
				if (this.cells[x - 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y - 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y - 1].getOccupied() == true) {
					neighbors++;
				}
			} else if (x == 0)// right bottom
			{
				if (this.cells[x + 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y - 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x + 1][y - 1].getOccupied() == true) {
					neighbors++;
				}
			} else {
				if (this.cells[x + 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y - 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x + 1][y - 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y - 1].getOccupied() == true) {
					neighbors++;
				}
			}
		}

		else if (y == 0) // left
		{
			if (x == 0) // left bottom
			{
				if (this.cells[x + 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x + 1][y + 1].getOccupied() == true) {
					neighbors++;
				}
			} else if (x == this.rows)// left top
			{
				if (this.cells[x - 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y + 1].getOccupied() == true) {
					neighbors++;
				}
			} else {
				if (this.cells[x + 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x + 1][y + 1].getOccupied() == true) {
					neighbors++;
				}
				if (this.cells[x - 1][y + 1].getOccupied() == true) {
					neighbors++;
				}
			}
		}

		else// =====EIGHT IF STATEMENTS=====
		{
			if (this.cells[x + 1][y].getOccupied() == true) {
				neighbors++;
			}
			if (this.cells[x - 1][y].getOccupied() == true) {
				neighbors++;
			}
			if (this.cells[x][y + 1].getOccupied() == true) {
				neighbors++;
			}
			if (this.cells[x][y - 1].getOccupied() == true) {
				neighbors++;
			}
			if (this.cells[x + 1][y + 1].getOccupied() == true) {
				neighbors++;
			}
			if (this.cells[x + 1][y - 1].getOccupied() == true) {
				neighbors++;
			}
			if (this.cells[x - 1][y + 1].getOccupied() == true) {
				neighbors++;
			}
			if (this.cells[x - 1][y - 1].getOccupied() == true) {
				neighbors++;
			}
		}

		return neighbors;
	}

	private 
	Cell[][] nextGen() {
		Cell[][] newCells = new Cell[this.rows][this.cols];
		//Cell[][] newCells = this.cells;

		for (int i = 0; i < this.cols; i++){
			for (int j = 0; j < this.rows; j++) {
				if (this.getNeighbors(i, j) == 2 || this.getNeighbors(i, j) == 3) {
					newCells[i][j] = new Cell(true);
				} else if (this.getNeighbors(i, j) < 2 || this.getNeighbors(i, j) > 3) {
					newCells[i][j] = new Cell(false);
				}
			}
		}

		return newCells;
	}

	public void updateEnvironment() {
		this.cells = this.nextGen();
	}

	public void cellAt(int x, int y) {
		System.out.println("Cell at: " + x + "," + y + " is: " + this.cells[y][x].getOccupied());
	}

	public void runSimulation() {

		StdDraw.clear();
		this.displayCells();
		this.updateEnvironment();
		StdDraw.show(500);
	}

}
