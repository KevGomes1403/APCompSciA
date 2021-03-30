public class PivotString {
    public static String pivoting(String orig, String pivot) {
        int start = 0;
        int end = 0;
        String result = "";
        int counter = 0;

        for (int i = 0; i < orig.length(); i++) {
            if (pivot.length() + i > orig.length() - 1) {
                break;
            }

            int endString = pivot.length() + i;
            String sub = orig.substring(i, endString);

            if (sub.equals(pivot)) {
                start = i;
                end = endString;
                counter++;
                break;
            }
        }

        if (counter == 0) {
            result = "Error: Pivot String not found.";
        } else {
            result = rearrangement(orig, start, end, pivot);
        }

        return result;
    }

    public static String rearrangement(String orig, int start, int end, String pivot) {
        String result = "";

        for (int i = end; i < orig.length(); i++) {
            result += orig.charAt(i);
        }

        result += pivot;

        for (int i = 0; i < start; i++) {
            result += orig.charAt(i);
        }

        return result;
    }
}
