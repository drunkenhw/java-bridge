package bridge;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Answer;
import bridge.domain.Bridge;
import bridge.domain.GameStatus;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void before() {
        bridgeGame = new BridgeGame(new Bridge(List.of("U")));
    }

    @DisplayName("사용자가 입력한 값에 따라 정답을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"RIGHT,U", "WRONG,D"})
    void finishTest(Answer answer, String userSelect) {
        Answer result = bridgeGame.move(userSelect);

        assertThat(result).isEqualTo(answer);
    }

    @DisplayName("게임이 끝나면 게임 상태를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"SUCCESS,U", "FAIL,D"})
    void gameStatus(GameStatus status, String userSelect) {
        bridgeGame.move(userSelect);

        GameStatus result = bridgeGame.getStatus();

        assertThat(result).isEqualTo(status);
    }

    @DisplayName("게임이 끝나지 않으면 게임 중을 반환한다.")
    @Test
    void gameStatusPlaying() {
        GameStatus status = bridgeGame.getStatus();

        assertThat(status).isEqualTo(GameStatus.PLAYING);
    }
}