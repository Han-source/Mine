package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import model.exceptionInBusiness.BizException;
import util.Pair;

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

		// 칸을 전부 만들자.
		cells = new Cell[height][width];
		List<Cell> list4Random = new ArrayList<>();

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Cell cell = new Cell(row, col);
				cells[row][col] = cell;
				list4Random.add(cell);

			}
		}
		// 뒤섞자 .
		Collections.shuffle(list4Random);
		// 개수만큼 골라서 지뢰 넣자.

		int choosen = 0;
		for (Cell cell : list4Random) {
			if (choosen++ < this.mines) {
				cell.setMine();
				// 나에게 지뢰가 있으니 주변에 있는 cell은 mine 개수를 증가시키기. (성능 향상 - 이차원으로 전체 반복이면 느려져요)
				// 또한 parallelStream()으로 각 위치의 안전 범위를 병렬 처리 => 성능 향상
				List<Pair<Integer, Integer>> aroundIndex = Direction.getAroundIntdex(cell.getRow(), cell.getCol());
				List<Pair<Integer, Integer>> listSafeIndex = aroundIndex.parallelStream().filter(p -> isSafeIndex(p))
						.collect(Collectors.toList());
				for (Pair<Integer, Integer> p : listSafeIndex) {
					cells[p.getFirst()][p.getSecond()].incMineCount(); // 내 주변에 있는
				}
			} else {
				break;
			}

		}
		// 어떤 칸 주위에 있는 칸에 들어있는 총 지뢰 개수를 미리 계산해 두자.

		// 주어진 총 개수 만큼 칸 생성하기.

		// width * height만큼 반복이 다 수행이 되었는데 mines개수보다 적게 만들어지는 경우 처리가 필요.

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getMines() {
		return mines;
	}

	private boolean isSafeIndex(Pair<Integer, Integer> p) {

		return p.getFirst() >= 0 && p.getFirst() < height && p.getSecond() >= 0 && p.getSecond() < width;
	}

}
