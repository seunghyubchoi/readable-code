package cleancode.minesweeper.tobe.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LandMineCellTest {

    @DisplayName("open() 호출 후 cell의 상태가 열린 상태가 맞는지 확인")
    @Test
    void 열림_후_상태_확인() {
        // given
        LandMineCell landMineCell = new LandMineCell();

        // when
        landMineCell.open();

        // then
        assertThat(landMineCell.isOpened()).isTrue();
        assertThat(landMineCell.isChecked()).isTrue();

    }

    @DisplayName("open() 호출 후 cell의 상태가 열린 상태가 맞는지 확인")
    @Test
    void 깃발_꽂기_후_상태_확인() {
        // given
        LandMineCell landMineCell = new LandMineCell();

        // when
        landMineCell.flag();

        // then
        assertThat(landMineCell.isFlagged()).isTrue();
        assertThat(landMineCell.isChecked()).isTrue();

    }

}
