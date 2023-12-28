/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author user
 */
public class NumberToVietnameseWords {
    private static final String[] UNIT = {"", "Nghìn", "Triệu", "Tỷ"};
    private static final String[] TEN = {"", "Mười", "Hai mươi", "Ba mươi", "Bốn mươi", "Năm mươi", "Sáu mươi", "Bảy mươi", "Tám mươi", "Chín mươi"};
    private static final String[] DIGIT = {"", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín"};

    public static String convertToVietnameseWords(int number) {
        if (number == 0) {
            return "không";
        }

        String result = "";
        int unitIndex = 0;

        do {
            int remainder = number % 1000;
            if (remainder != 0) {
                String block = convertBlock(remainder);
                result = block + " " + UNIT[unitIndex] + " " + result;
            }

            unitIndex++;
            number /= 1000;
        } while (number > 0);

        return result.trim();
    }

    private static String convertBlock(int number) {
        if (number == 0) {
            return "";
        }

        String result = "";

        int hundred = number / 100;
        int ten = number % 100 / 10;
        int digit = number % 10;

        if (hundred > 0) {
            result += DIGIT[hundred] + " trăm ";
        }

        if (ten > 1) {
            result += TEN[ten] + " ";
            if (digit > 0) {
                result += "lẻ " + DIGIT[digit];
            }
        } else if (ten == 1) {
            result += "mười ";
            if (digit > 0) {
                result += DIGIT[digit];
            }
        } else if (digit > 0) {
            result += DIGIT[digit];
        }

        return result.trim();
    }

    public static void main(String[] args) {
        int totalAmount = 123456789;
        String totalInWords = convertToVietnameseWords(totalAmount);
        System.out.println("Total in words: " + totalInWords);
    }
}

