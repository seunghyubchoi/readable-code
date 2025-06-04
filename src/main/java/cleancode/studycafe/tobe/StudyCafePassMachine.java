package cleancode.studycafe.tobe;

import cleancode.studycafe.tobe.config.StudyCafeConfig;
import cleancode.studycafe.tobe.exception.AppException;
import cleancode.studycafe.tobe.io.InputHandler;
import cleancode.studycafe.tobe.io.OutputHandler;
import cleancode.studycafe.tobe.io.StudyCafeFileHandler;
import cleancode.studycafe.tobe.model.*;

import java.util.Optional;

public class StudyCafePassMachine {

  private final InputHandler inputHandler;
  private final OutputHandler outputHandler;
  private final StudyCafeFileHandler studyCafeFileHandler;

  public StudyCafePassMachine(StudyCafeConfig studyCafeConfig) {
    this.inputHandler = studyCafeConfig.getInputHandler();
    this.outputHandler = studyCafeConfig.getOutputHandler();
    this.studyCafeFileHandler = studyCafeConfig.getStudyCafeFileHandler();
  }

  public void run() {
    try {
      showInitialMessages();
      StudyCafePassType studyCafePassType = getPassType();
      StudyCafePass selectedPass = getPassBy(studyCafePassType);
      getLockerPassBy(selectedPass);
    } catch (AppException e) {
      outputHandler.showSimpleMessage(e.getMessage());
    } catch (Exception e) {
      outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
    }
  }

  private StudyCafePassType getPassType() {
    return inputHandler.getPassTypeSelectingUserAction();
  }

  private void getLockerPassBy(StudyCafePass selectedPass) {
    if (!doesSelectedTypeNeedLocker(selectedPass)) {
      return;
    }

    Optional<StudyCafeLockerPass> optionalLocker =
      findMatchingLockerPass(selectedPass)
        .filter(this::isLockerSelectedByUser);

    outputHandler.showPassOrderSummary(selectedPass, optionalLocker.orElse(null));
  }

  private Optional<StudyCafeLockerPass> findMatchingLockerPass(StudyCafePass selectedPass) {
    return studyCafeFileHandler.readLockerPasses()
      .stream()
      .filter(option ->
        option.getPassType() == selectedPass.getPassType() &&
          option.getDuration() == selectedPass.getDuration())
      .findFirst();
  }

  private boolean isLockerSelectedByUser(StudyCafeLockerPass lockerPass) {
    outputHandler.askLockerPass(lockerPass);
    return inputHandler.getLockerSelection();
  }

  private boolean doesSelectedTypeNeedLocker(StudyCafePass selectedPass) {
    return selectedPass.doesTypeNeedLocker();
  }

  private StudyCafePass getPassBy(StudyCafePassType studyCafePassType) {
    StudyCafePasses selectedPassList = filterPassesBy(studyCafePassType);
    outputHandler.showPassListForSelection(selectedPassList);
    StudyCafePass selectedPass = inputHandler.getSelectPass(selectedPassList);
    outputHandler.showPassOrderSummary(selectedPass, null);
    return selectedPass;
  }

  private StudyCafePasses filterPassesBy(StudyCafePassType studyCafePassType) {
    StudyCafePasses studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
    return studyCafePassType.getPassListBy(studyCafePasses);
  }

  private void showInitialMessages() {
    outputHandler.showWelcomeMessage();
    outputHandler.showAnnouncement();
    outputHandler.askPassTypeSelection();
  }
}
