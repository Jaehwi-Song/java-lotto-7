package lotto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = generateRandomNumbers();
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
    // TODO: 추가 기능 구현
    private List<Integer> generateRandomNumbers() {
         return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void printLottery() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        int matchCount = 0;
        for (int number: numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean containBonusNumber(int bonus) {
        return numbers.contains(bonus);
    }
}
