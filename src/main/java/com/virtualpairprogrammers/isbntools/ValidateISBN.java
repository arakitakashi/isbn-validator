package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {
    public boolean checkISBN(String isbn) {
        if (isbn.length() != 10) throw new NumberFormatException("入力値が10桁ではありません");
        int total = 0;

        for (int i = 0; i < isbn.length(); i++) {
            if(!Character.isDigit(isbn.charAt(i))) throw new IllegalArgumentException("入力値が数値の文字列ではありません");
            int num = Character.getNumericValue(isbn.charAt(i));
            total += num * (10 - i);
        }

        return total % 11 == 0;
    }
}
