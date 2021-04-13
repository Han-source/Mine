package model;

public class Cell {
	private int row, col;
	private boolean hasMine = false;
	//내 주변에 있는 지뢰 개수
	private int aroundMineCount = 0;
	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	protected int getRow() {
		return row;
	}

	protected int getCol() {
		return col;
	}

	public void setMine() {
		hasMine = true;

	}

	public void incMineCount() {
		aroundMineCount++;
		
	}
	
}
