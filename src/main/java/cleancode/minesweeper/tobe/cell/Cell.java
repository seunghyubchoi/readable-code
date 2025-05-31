package cleancode.minesweeper.tobe.cell;

public interface Cell {

    String FLAG_SIGN = "⚑";
    String UNCHECKED_SIGN = "□";

    boolean hasLandMineCount();

    String getSign();

    boolean isLandMine();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();

    boolean isFlagged();
}
