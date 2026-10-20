package numbers;

public class NumberProperties {
    /* Um número Buzz é quando ele é divisível por 7 ou termina com 7
    Um número é Duck quando ele possui o algarismo 0 em alguma casa.
    */
     static boolean isBuzzNumbers(long number) {

        boolean isBuzzNumber = false;

        if ((number % 10 == 7) || (number % 7 == 0)){
            isBuzzNumber = true;
        }
        return isBuzzNumber;
    }
    static boolean isEven(long number){ // verifica se é par
         boolean isEven = false;
         if (number % 2 == 0){
             isEven = true;
         }
         return isEven;
    }
    static boolean isOdd(long number){ // verifica se é impar
        boolean isOdd = false;
        if (number % 2 != 0){
            isOdd = true;
        }
        return isOdd;
    }
    static boolean isDuck(long number){
        boolean isDuck = false;
        // Converte o número para String e verifica se contém "0"
        if (String.valueOf(number).contains("0")) {
            isDuck = true;
        }
        return  isDuck;
    }
    static boolean isPalindromic(long number){
            String text = String.valueOf(number);
            String invertedText = new StringBuilder(text).reverse().toString();
            return text.equals(invertedText);
    }
    static boolean isGapful(long number) {
        String s = String.valueOf(number);
        if (s.length() < 3) {
            return false;
        }
        // Junta o primeiro caractere com o último
        String combinacao = "" + s.charAt(0) + s.charAt(s.length() - 1);
        long divisor = Long.parseLong(combinacao);
        return number % divisor == 0;
    }

}
