package cleancode.studycafe.tobe.model;

import java.util.List;
import java.util.stream.Stream;

public class StudyCafeLockerPasses {
  private final List<StudyCafeLockerPass> studyCafeLockerPassesList;

  public StudyCafeLockerPasses(List<StudyCafeLockerPass> studyCafeLockerPassesList) {
    this.studyCafeLockerPassesList = studyCafeLockerPassesList;
  }

  public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> studyCafeLockerPasses) {
    return new StudyCafeLockerPasses(studyCafeLockerPasses);
  }

  public StudyCafeLockerPass extractListBy(StudyCafePass studyCafePass) {
    return studyCafeLockerPassesList
              .stream()
              .filter(
                option -> option.getPassType() == studyCafePass.getPassType()
                                          && option.getDuration() == studyCafePass.getDuration())
              .findFirst()
              .orElse(null);
  }

  public Stream<StudyCafeLockerPass> stream() {
    return studyCafeLockerPassesList.stream();
  }


}
