package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.config.StudyCafeConfig;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;

public class StudyCafeApplication {

  public static void main(String[] args) {
    StudyCafeConfig studyCafeConfig = new StudyCafeConfig(new InputHandler(), new OutputHandler(), new StudyCafeFileHandler());

    StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeConfig);

    studyCafePassMachine.run();

  }

}
