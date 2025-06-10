package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gameLevel.Advanced;
import cleancode.minesweeper.tobe.gameLevel.GameLevel;
import cleancode.minesweeper.tobe.position.CellPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameBoardTest {

    @DisplayName("레벨에 맞는 좌표 크기 및 지뢰 개수 여부 확인")
    @Test
    void 게임보드_좌표_크기_및_지뢰_개수_확인() {
        // given
        GameLevel gameLevel = new Advanced();
        GameBoard gameBoard = new GameBoard(gameLevel);
        gameBoard.initializeGame();

        // when
        int mineCount = 0;

        for ( int i = 0; i < gameBoard.getRowSize(); i++ ) {
            for ( int j = 0; j < gameBoard.getColSize(); j++ ) {
                CellPosition cellPosition = CellPosition.of(i, j);
                if(gameBoard.isLandMineCellAt(cellPosition)) {
                    mineCount++;
                }
            }
        }

        // then
        assertThat(mineCount).isEqualTo(gameLevel.getLandMineCount());
        // 동일 좌표 내 중복 지뢰 생성 가능
    }

    @DisplayName("레벨의 설정된 값 기준 CellPosition 할당 가능 여부 기능 확인")
    @Test
    void isInvalidCellPosition() {
        // given
        Advanced gameLevel = new Advanced();
        GameBoard gameBoard = new GameBoard(gameLevel);
        gameBoard.initializeGame();

        int rowLimit = gameLevel.getRowSize();
        int colLimit = gameLevel.getColSize();

        CellPosition cellPosition1 = CellPosition.of(rowLimit - 1, colLimit - 1);
        CellPosition cellPosition2 = CellPosition.of(rowLimit, colLimit);
        CellPosition cellPosition3 = CellPosition.of(rowLimit + 1, colLimit +  1);

        // when & then
        assertThat(gameBoard.isInvalidCellPosition(cellPosition1)).isFalse();
        assertThat(gameBoard.isInvalidCellPosition(cellPosition2)).isTrue();
        assertThat(gameBoard.isInvalidCellPosition(cellPosition3)).isTrue();

    }

    @DisplayName("모든 셀 열림 여부 판단 메서드 확인")
    @Test
    void isAllOpenedCheck() {
        // given
        Advanced gameLevel = new Advanced();
        GameBoard gameBoard = new GameBoard(gameLevel);
        gameBoard.initializeGame();
        for (int i = 0; i < gameBoard.getRowSize(); i++) {
            for (int j = 0; j < gameBoard.getColSize(); j++) {
                gameBoard.openAt(CellPosition.of(i, j));
            }
        }

        // when & then
        assertThat(gameBoard.isAllCellChecked()).isTrue();

    }

}
