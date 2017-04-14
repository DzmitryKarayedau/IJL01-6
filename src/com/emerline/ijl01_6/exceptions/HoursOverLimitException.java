package com.emerline.ijl01_6.exceptions;

/**
 * Created by dzmitry.karayedau on 13-Apr-17.
 */
public class HoursOverLimitException extends Exception {
    public HoursOverLimitException() {
    }

    public HoursOverLimitException(String s) {
        super(s);
    }
}
