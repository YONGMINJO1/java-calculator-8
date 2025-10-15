package calculator;

public class StringAddCalculator {

    public static int add(String input) {
        // 입력값이 null 이거나 빈 문자열이면 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 쉼표 또는 콜론을 기준으로 구분
        String[] numbers = input.split("[,:]");

        // 숫자 더하기
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
