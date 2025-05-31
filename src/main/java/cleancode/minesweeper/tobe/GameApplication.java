package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gameLevel.Advanced;
import cleancode.minesweeper.tobe.gameLevel.GameLevel;
import cleancode.minesweeper.tobe.gameLevel.Middle;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        GameLevel gameLevel = new Advanced();
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        Minesweeper minesweeper = new Minesweeper(gameLevel, inputHandler, outputHandler);
        minesweeper.initialize();
        minesweeper.run();
    }

    /**
     * DIP (Dependency Inversion Principle)
     * : 고수준 모듈과 저수준 모듈이 직접적으로 의존하는 것이 아니라
     * : 추상화에 서로 의존
     * DI (Dependency Injection)
     * : 필요한 의존성을 외부에서 주입 받는다
     * : "3" A가 B를 생성해서 사용하는 게 아니라 제 3자(스프링에선 스프링 컨텍스트)가 의존성을 맺어줌
     * IoC (Inversion of Control)
     * : 프로그램의 흐름을 개발자가 아닌 프레임워크가 담당하게 함
     * : 객체를 직접 생성하고 생명 주기를 관리해준다
     *
     */
}
