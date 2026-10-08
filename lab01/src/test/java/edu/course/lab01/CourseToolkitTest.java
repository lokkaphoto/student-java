package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);

    }

    /** isPrime */

    @Test
    void returnsFalseForOne() {
        boolean result = CourseToolkit.isPrime(1);

        assertFalse(result);
    }

    @Test
    void returnFalseSquare() {
        boolean result = CourseToolkit.isPrime(49);

        assertFalse(result);
    }

    @Test
    void returnTrueTwo() {
        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }

    @Test
    void returnFalseComposite() {
        boolean result = CourseToolkit.isPrime(9);

        assertFalse(result);
    }

    /** isPalindrome */
    @Test
    void returnTruePalindrome() {
        boolean result = CourseToolkit.isPalindrome("топот");

        assertTrue(result);
    }

    @Test
    void returnFalsePalindrome() {
        boolean result = CourseToolkit.isPalindrome("Шла Саша по шоссе");

        assertFalse(result);
    }

    @Test
    void returnFalsePalindromeSpace() {
        boolean result = CourseToolkit.isPalindrome("Леша на полке клопа нашел");

        assertFalse(result);
    }

    @Test
    void throwsExceptionForNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            CourseToolkit.isPalindrome(null);
        });
    }

    /** average */
    @Test
    void returnsAverageForPositiveNumbers() {
        int[] values = { 2, 4, 6 };

        double result = CourseToolkit.average(values);

        assertEquals(4.0, result, 0.0001);
    }

    @Test
    void returnsAverageForNegativeNumbers() {
        int[] values = { -1, -3, -5 };

        double result = CourseToolkit.average(values);

        assertEquals(-3.0, result, 0.0001);
    }

    @Test
    void throwsExceptionForNullArray() {
    assertThrows(IllegalArgumentException.class, () -> {
        CourseToolkit.average(null);
    });
    }
