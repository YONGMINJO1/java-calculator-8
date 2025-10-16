package calculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int add(String input) {
        // 입력값이 null 이거나 빈 문자열이면 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = delimiter + "|" + Pattern.quote(input.substring(2, delimiterEndIndex));
            input = input.substring(delimiterEndIndex + 1);
        }

        // 쉼표 또는 콜론을 기준으로 구분
        String[] numbers = input.split(delimiter);

        // 숫자 더하기
        int sum = 0;
        for (String number : numbers) {

            if (number.isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력값이 포함되어 있습니다.");
            }
            try {
                int value = Integer.parseInt(number);
                if (value < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
                }
                sum += value;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력값이 포함되어 있습니다.");
            }
        }
        return sum;
    }
}
