package cleancode.studycafe.tobe.model;

import cleancode.studycafe.tobe.io.sign.StudyCafePassSelector;

public enum StudyCafePassType implements StudyCafePassSelector {

    HOURLY("시간 단위 이용권") {
      @Override
      public StudyCafePasses getPassListBy(StudyCafePasses studyCafePasses) {
        return studyCafePasses.extractListBy(this);
      }

      @Override
      public boolean doesTypeNeedLocker() {
        return false;
      }
    },
    WEEKLY("주 단위 이용권") {
      @Override
      public StudyCafePasses getPassListBy(StudyCafePasses studyCafePasses) {
        return studyCafePasses.extractListBy(this);
      }

      @Override
      public boolean doesTypeNeedLocker() {
        return false;
      }
    },
    FIXED("1인 고정석") {
      @Override
      public StudyCafePasses getPassListBy(StudyCafePasses studyCafePasses) {
        return studyCafePasses.extractListBy(this);
      }

      @Override
      public boolean doesTypeNeedLocker() {
        return true;
      }
    };

    private final String description;

    StudyCafePassType(String description) {
        this.description = description;
    }
}
