package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SharedTestData {

    private final static Logger logger = LoggerFactory.getLogger(SharedTestData.class);

    private static String token;

    private static String resetPasswordToken;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        SharedTestData.token = token;
    }

    public static String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public static void setResetPasswordToken(String resetPasswordToken) {
        SharedTestData.resetPasswordToken = resetPasswordToken;
    }
}
