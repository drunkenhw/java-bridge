package bridge.domain;

public enum GameStatus {
    SUCCESS("성공"),
    FAIL("실패"),
    PLAYING("실행 중")
    ;

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }
}