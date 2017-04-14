package com.emerline.ijl01_6.exceptions;

/**
 * Created by dzmitry.karayedau on 13-Apr-17.
 */
public class PriceOverLimitException extends Exception {
    public PriceOverLimitException() {
    }

    public PriceOverLimitException(String s) {
        super(s);
    }
}
