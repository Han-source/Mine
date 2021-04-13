package control;

import model.Board;
import model.BoardType;
import model.exceptionInBusiness.BizException;


public class MineController {
	private Board board;
	
	private MineController() {
		try {
			board =new Board(BoardType.초급);
//			new MineWin(board);
		} catch (BizException e) {
			e.printStackTrace();
			
		}

	}
	
	public static void main(String[] args) {
		new MineController();	
		}

}