package model;

public enum BoardType {
	초급(9, 9, 10), 중급(16, 16, 40), 고급(30, 16, 99), 커스텀(0, 0, 0);

	public final int width, height, mines;

	private BoardType(int width, int height, int mines) {
		this.width = width;
		this.height = height;
		this.mines = mines;
	}

}

