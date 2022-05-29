public class ChopMeaningfullphrase {
    public static String solution(String message, int K) {
        if (message.length() < K) {
            return message;
        }

        String chopStr = message.substring(0, K);
        char lastchar = message.charAt(K);
        if (lastchar == ' ') {
            return chopStr;
        }

        int spaceIndex = chopStr.lastIndexOf(' ');
        String result = chopStr.substring(0, spaceIndex);
        return result;
    }

    public static void main(String args[]) {

       System.out.println(solution("The quick brown fox jumps over the lazy dog", 39));

    }

}
