package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 로또 한 장을 의미하는 객체
 */
public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    /**
     * 로또 번호를 받아 새로운 로또를 생성합니다.
     *
     * @param numbers 6개의 로또 번호가 담긴 리스트
     * @throws IllegalArgumentException 로또 번호가 유효하지 않은 경우
     */
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    /**
     * 로또 번호의 개수가 정확히 6개인지 검증합니다.
     *
     * @param numbers 검증할 로또 번호 리스트
     * @throws IllegalArgumentException 번호의 개수가 6개가 아닌 경우
     */
    private void validate(List<Integer> numbers) {

        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    /**
     * 현재 로또의 번호들을 조회합니다.
     * 반환된 리스트는 수정이 불가능합니다.
     *
     * @return 로또 번호들이 담긴 수정 불가능한 리스트
     */
    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    /**
     * 특정 숫자가 현재 로또 번호에 포함되어 있는지 확인합니다.
     *
     * @param number 확인할 숫자
     * @return 포함되어 있으면 true, 없으면 false
     */
    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    /**
     * 다른 로또와 비교하여 일치하는 번호의 개수를 반환합니다.
     *
     * @param other 비교할 다른 로또
     * @return 일치하는 번호의 개수
     */
    public int countMatchingNumbers(Lotto other) {
        return (int) numbers.stream()
                .filter(other::hasNumber)
                .count();
    }

    /**
     * 로또 번호들을 문자열로 변환합니다.
     *
     * @return 로또 번호들을 담은 문자열
     */
    @Override
    public String toString() {
        return numbers.toString();
    }
}