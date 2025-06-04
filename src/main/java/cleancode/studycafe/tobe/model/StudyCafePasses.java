  package cleancode.studycafe.tobe.model;

  import java.util.List;

  public class StudyCafePasses {
    private final List<StudyCafePass> studyCafePassesList;

    public StudyCafePasses(List<StudyCafePass> studyCafePassesList) {
      this.studyCafePassesList = studyCafePassesList;
    }

    public static StudyCafePasses of(List<StudyCafePass> studyCafePasses) {
      return new StudyCafePasses(studyCafePasses);
    }

    public StudyCafePasses extractListBy(StudyCafePassType studyCafePassType) {
      List<StudyCafePass> filteredList = studyCafePassesList.stream()
        .filter(studyCafePass -> studyCafePass.getPassType() == studyCafePassType)
        .toList();

      return of(filteredList);
    }

    public int size() {
      return studyCafePassesList.size();
    }

    public StudyCafePass get(int index) {
      return studyCafePassesList.get(index);
    }





  }
