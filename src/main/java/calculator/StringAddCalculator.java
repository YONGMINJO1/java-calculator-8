package calculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int add(String input) {
        // 입력값이 null 이거나 빈 문자열이면 0 반환
        if (isNullOrEmpty(input)) {
            return 0;
        }

        input = input.replace("\\n", "\n");

        String delimiter = extractDelimiter(input);

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            input = input.substring(delimiterEndIndex + 1);
        }

        // 쉼표 또는 콜론을 기준으로 구분
        String[] numbers = input.split(delimiter);

        // 숫자 더하기
        int sum = 0;
        for (String number : numbers) {
            sum += parseAndValidateNumber(number);
        }
        return sum;
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String extractDelimiter(String input) {
        String delimiter = ",|:";

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("커스컴 구분자 지정이 잘못되었습니다.");
            }

            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiter += "|" + Pattern.quote(customDelimiter);
        }
        return delimiter;
    }

    private static int parseAndValidateNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("입력값에 공백이 포함되어 있습니다.");
        }
        int value;
        try {
            value = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값이 포함되어 있습니다.");
        }
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
        }
        return value;
    }
}
