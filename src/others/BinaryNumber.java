package others;

/**
 * 整数转化为 2 进制
 *
 * @author ：隋亮亮
 * @since ：2020/6/21 8:44
 */
public class BinaryNumber {
    public static void main(String[] args) {
        int n = 31;

        String s = binaryNumber(n);

        System.out.println("s = " + s);
    }

    public static String binaryNumber(int n) {
        int tmp = Math.abs(n);
        if(tmp <= 1) {
            return String.valueOf(tmp);
        }

        StringBuilder sb = new StringBuilder();

        while(tmp > 0) {
            sb.append(tmp % 2);
            tmp /= 2;
        }

        // 填充
        int len = sb.length();
        for (int i = 0; i < 32 - len; i++) {
            sb.insert(0, 0);
        }

        if(n < 0) {
            int count = 0;
            // TODO: 按位取反 + 1
            for (int i = sb.length() - 1; i >= 0; i--) {
                if(sb.charAt(i) == '0') {
                        sb.replace(i, i+ 1, "1");
                } else {
                        sb.replace(i ,i + 1, "0");
                }
            }

            for (int i = sb.length() - 1; i >= 0 ; i--) {
                if(i == sb.length()) {
                    if(sb.charAt(i) == '0') {
                        sb.replace(i, i+ 1, "1");
                    } else {
                        sb.replace(i ,i + 1, "0");
                        count = 1;
                    }
                } else {

                }
            }
        }

        return sb.toString();
    }
}
