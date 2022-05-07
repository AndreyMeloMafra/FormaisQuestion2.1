import java.util.regex.Pattern;

public class QuestionValidator {

    String alternative;
    String regularExpression;
    String description;

    private QuestionValidator(String alternative, String description, String regularExpression) {
        this.alternative = alternative;
        this.regularExpression = regularExpression;
        this.description = description;
    }

    public static QuestionValidator of(String alternative, String description, String regularExpression) {
        return new QuestionValidator(alternative, description, regularExpression);
    }

    public void testAllResults(QuestionValidator question, String[] resultPossibles) {
        Logger.logTitle("Resposta questão " + question.alternative);
        Logger.log("");
        Logger.logDescription("Descrição: " + question.description);
        Logger.log("");
        Logger.log("Expressão regular: " + question.regularExpression);
        Logger.log("");
        tester(question.regularExpression, resultPossibles);
    }

    private void tester(String regularExpression, String[] resultPossibles) {
        for (int iterator = 0; iterator < resultPossibles.length; iterator++) {
            test(regularExpression, resultPossibles[iterator]);
        }
    }

    public static boolean test(String regularExpression, String resultExpected) {
        String resultToTest = resultExpected;
        boolean expressionResult = Pattern.matches(regularExpression, resultExpected);
        String expressionMessage = "Resultado: " + expressionResult;
        if (resultToTest.isEmpty()) {
            resultToTest = "Vazio";
        }
        Logger.log("Cadeia testada: " + resultToTest);
        if (expressionResult) {
            Logger.logPositive(expressionMessage);
        } else {
            Logger.logNegative(expressionMessage);
        }

        Logger.log("");

        return expressionResult;
    }
}
