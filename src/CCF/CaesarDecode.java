package CCF;

import java.util.Scanner;

/**
 * Created on 2020/4/19 0019
 * BY Jianlong
 */
public class CaesarDecode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pw = in.nextLine();
        int code;

        char[] out = new char[pw.length()];

        for (int i=0; i<pw.length(); i++){
            char w = pw.charAt(i);
            code = w+3;
            if (code > 122){
                code = 96 + (code-122);
            }
            out[i] = (char) code;
        }

        System.out.print(out);
    }
}
