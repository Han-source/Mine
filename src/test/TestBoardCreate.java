package test;

import org.junit.jupiter.api.Test;

import model.Board;
import model.BoardType;
import model.exceptionInBusiness.BizException;

class TestBoardCreate {

	@Test
	void test() {
		try {
			Board board = new Board(BoardType.초급);
			int i = 0;
			i++;
			
		} catch (BizException e) {
			e.printStackTrace();
		}
	}

}
