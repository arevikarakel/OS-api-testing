package providers.dataProviders;

public final class SharedTestData {

    private static String token;

    private static String resetPasswordToken;

    private static int userId;

    private static int categoryId;

    private static int subCategoryId;

    public static int getSubCategoryId() {
        return subCategoryId;
    }

    public static void setSubCategoryId(int subCategoryId) {
        SharedTestData.subCategoryId = subCategoryId;
    }

    private static String categoryTitle;

    public static String getCategoryTitle() {
        return categoryTitle;
    }

    public static void setCategoryTitle(String categoryTitle) {
        SharedTestData.categoryTitle = categoryTitle;
    }

    public static void setCategoryId(int categoryId) {
        SharedTestData.categoryId = categoryId;
    }

    public static int getCategoryId() {
        return categoryId;
    }

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

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        SharedTestData.userId = userId;
    }
}