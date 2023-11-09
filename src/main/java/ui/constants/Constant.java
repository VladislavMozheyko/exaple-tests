package ui.constants;

public class Constant {
    public static class TimeOutVariable {
        public static final int IMPLICIT_WAIT = 20;
        public static final int EXPLICIT_WAIT = 10;
        public static final int PAGE_LOAD_WAIT = 20;
    }

    public static class Urls {
        public static final String HEROKU_HOME = "https://www.heroku.com/home";
        public static final String BBC_HOME = "https://www.bbc.com/";
        public static final String REQRES = "https://reqres.in/";
    }

    public static class Titles {
        public static final String HEROKU_SIGNIN_TITLE = "Heroku | Sign up";
        public static final String BBC_SIGNIN_TITLE = "BBC – Sign in";
        public static final String BBC_REGISTER_TITLE = "BBC – Register";
        public static final String BBC_DATA_TITLE = "BBC – Register – enter your date of birth";
        public static final String BBC_REG_USER_TITLE = "BBC – Register – enter your details";
        public static final String BBC_SUCCESS_REG_TITLE = "BBC – Register – thank you";
        public static final String BBC_MAIN_PAGE_TITLE = "BBC - Homepage";
    }

    public static class Values {
        public static final String FIRST_NAME = StringModifier.getUniqueString("tuzik");
        public static final String LAST_NAME = "zloy";
        public static final String EMAIL = "zloytuzikvsehkusaet@gmail.com";
        public static final String COMPANY_NAME = "vseh kusat";
        public static final Integer PAUSE = 3;
        public static final Integer RESPONSE200 = 200;
        public static final Integer RESPONSE400 = 400;
        public static final Integer RESPONSE204 = 204;
        public static final String DAY = "11";
        public static final String MONTH = "10";
        public static final String YEAR = "2007";
        public static final String PASSWORD = "Nuikak12345";
        public static final String LIST_USERS = "api/users?page=2";
        public static final String REGISTER_SUCCESSFUL = "api/register";
        public static final String LIST_RESOURCE = "api/unknown";
        public static final String DEL_USER_2 = "api/users/2";

    }
}
