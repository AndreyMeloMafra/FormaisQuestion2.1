import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
        String[] question1Matchs = new String[] { "aa", "a", "aaa", "aaaa",
                "aaaaaaaaaaa", "baa", "abb", "aabb", "" };
        QuestionValidator question1 = QuestionValidator.of("A", "Começa com aa",
                "aa+b*");
        question1.testAllResults(question1, question1Matchs);

        String[] question2Matchs = new String[] { "aa", "abaa", "aabaa",
                "baaaaaaaaaaa", "bb", "bbbbbbbbbaaaaaaaaaa" };
        QuestionValidator question2 = QuestionValidator.of("B", "Não começa com aa",
                "[a|b]*[b+][ba]*");
        question1.testAllResults(question2, question2Matchs);

        String[] question3Matchs = new String[] { "aa", "abaa", "aabbb",
                "baaaaaaaaaabbba", "bb", "bbbbbbbbbaaaaaaaaaabbb", "bbb", "", "aaabbabbbbb" };
        QuestionValidator question3 = QuestionValidator.of("C", "Termina com bbb",
                "[ab]*bbb");
        question1.testAllResults(question3, question3Matchs);

        String[] question4Matchs = new String[] { "aa", "abaa", "aabbb",
                "baaaaaaaaaabbba", "bb", "bbbbbbbbbaaaaaaaaaabbb", "bbb", "", "aaabbbabbbbb" };
        QuestionValidator question4 = QuestionValidator.of("D", "Contém a subcadeia aabbb",
                "[ab]*aabbb[ab]*");
        question1.testAllResults(question4, question4Matchs);

        String[] question5Matchs = new String[] { "aa", "abaa", "aabbb",
                "baaaaaaaaaabbba", "bb", "bbbbbbbbbaaaaaaaaaabbb", "bbb", "", "aaabbbabbbbb", "a", "b" };
        QuestionValidator question5 = QuestionValidator.of("E", "Possuem comprimento maior ou igual a 3",
                "[ab]{3,}");
        question1.testAllResults(question5, question5Matchs);

        String[] question6Matchs = new String[] { "aa", "abaa", "aabbb",
                "baaaaaaaaaabbba", "bb", "bbbbbbbbbaaaaaaaaaabbb", "bbb", "", "aaabbbabbbbb", "a", "b" };
        QuestionValidator question6 = QuestionValidator.of("F", "Possuem comprimento menor ou igual a 3",
                "[ab]{0,3}");
        question1.testAllResults(question6, question6Matchs);

        String[] question7Matchs = new String[] { "aaa", "bab", "aabbb",
                "baaaaaaaaaabbba", "bb", "bbbbbbbbbaaaaaaaaaabbb", "bbb", "", "aaabbbabbbbb", "aba" };
        QuestionValidator question7 = QuestionValidator.of("F", "Possuem comprimento diferente de 3",
                "[ab]{0,2}|[ab]{4,}");
        question1.testAllResults(question7, question7Matchs);

        String[] question8Matchs = new String[] { "aaa", "bab", "aabbb",
                "baaaaaaaaaabbba", "bb", "bbbbbbbbbaaaaaaaaaabbb", "bbb", "", "aaabbbabbbbb", "aba" };
        QuestionValidator question8 = QuestionValidator.of("F", "Possuem comprimento par",
                "[[ab]{2}]*");
        question1.testAllResults(question8, question8Matchs);

        String[] question12Matchs = new String[] { "aa", "bab", "aabbb",
                "baaaaaaaaaabbba", "bb", "bbbbbbbbbaaaaaaaaaabbb", "bbb", "", "aaabbbabbbbb", "aba" };
        QuestionValidator question12 = QuestionValidator.of("L", " Possuem quantidade par de símbolos a",
                "(?i)(aa)");
        question1.testAllResults(question12, question12Matchs);
    }
}
