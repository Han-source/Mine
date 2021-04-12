package model;

import model.exceptionInBusiness.BizException;

public class Board {
	private BoardType boardType;
	private int width, height, mines;
	private Cell[][] cells;

	public Board(BoardType boardType) throws BizException {
		if (boardType == BoardType.커스텀) {
			throw new BizException("커스텀으로는 호출 불가합니다.");
		}
		this.boardType = boardType;
		this.width = boardType.width;
		this.height = boardType.height;
		this.mines = boardType.mines;

		// 주어진 총 개수 만큼 칸 생성하기.
		int constructedMineTot = 0;
		float genRatio = (float) mines / (width * height);
		
		cells = new Cell[height][width];
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				boolean withMine = genRatio > Math.random(); 
				cells[row][col] = new Cell();

			}
		}
	}

}
