package cleancode.minesweeper.tobe.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CellPositionTest {

    @DisplayName("같은 좌표 값을 받은 CellPosition이 같은 좌표인지 아닌지 확인")
    @Test
    void getCellPositionFromUser() {
        // 다른 객체임에도 같은 좌표 값을 가졌다면
        // 같은 좌표임을 확인해줘야 하기에
        // 동등비교 메서드 포함 확인 차

        // given
        int colIndex = 1;
        int rowIndex = 1;

        int anotherColIndex = 1;
        int anotherRowIndex = 1;

        // when
        CellPosition cellPosition1 = CellPosition.of(colIndex, rowIndex);
        CellPosition cellPosition2 = CellPosition.of(anotherColIndex, anotherRowIndex);

        // then
        assertThat(cellPosition1).isEqualTo(cellPosition2);
        assertThat(cellPosition1.hashCode()).isEqualTo(cellPosition2.hashCode());
    }

    @DisplayName("움직일 수 없는 상대 좌표 입력 시 예외 발생 여부 확인")
    @Test
    void calculatePositionBy() {
        // given
        CellPosition cellPosition = CellPosition.of(0, 0);
        RelativePosition relativePosition = RelativePosition.of(-1, -1);

        // when
        // then
        assertThatThrownBy(() -> cellPosition.calculatePositionBy(relativePosition))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("움직일 수 있는 좌표가 아닙니다.");
    }
}
