public class BinarytoString {
    public static String binaryToText(String binary)
    {
        // Write your code here!

        // initialize result String
        String result = "";
        char charValue;

        //loop through entire String
        for (int i = 8; i <= binary.length(); i += 8) {

            result += (char) binaryToDecimal(binary.substring(i - 8, i));
        }
        // return result
        return result;
    }

    public static int binaryToDecimal(String binaryString)
    {
        // Copy over your binaryToDecimal method here
        // It will be useful when writing your binaryToText method
        int exponent = binaryString.length() - 1;
        int decimalValue = 0;

        for (int i = 0; i < binaryString.length(); i++) {
            int placeValue = (int) Math.pow(2, exponent);
            char place = binaryString.charAt(i);
            int digit = Character.getNumericValue(place);

            decimalValue += digit * placeValue;

            exponent--;
        }

        return decimalValue;
    }
}
