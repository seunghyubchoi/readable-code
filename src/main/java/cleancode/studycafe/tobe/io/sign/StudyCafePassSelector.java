package cleancode.studycafe.tobe.io.sign;

import cleancode.studycafe.tobe.model.StudyCafePasses;

public interface StudyCafePassSelector {
  StudyCafePasses getPassListBy(StudyCafePasses studyCafePasses );
  boolean doesTypeNeedLocker();
}
