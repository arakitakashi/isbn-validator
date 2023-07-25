package com.virtualpairprogrammers.isbntools;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class ValidateISBNTest {

    @Test
    void 有効なISBNである() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertThat(result).isTrue();
    }

    @Test
    void 無効なISBNである() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertThat(result).isFalse();
    }

    @Test
    void 番号9桁は許可されていない() {
        ValidateISBN validator = new ValidateISBN();

        assertThatThrownBy(() -> {
            boolean result = validator.checkISBN("014044911");
        })
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("入力値が10桁ではありません");
    }

    @Test
    void 文字列は許可されていない() {

        ValidateISBN validator = new ValidateISBN();

        assertThatThrownBy(() -> {
            boolean result = validator.checkISBN("xxxxxxxxxx");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("入力値が数値の文字列ではありません");
    }
}