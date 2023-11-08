package ui.constants;

public class Constant {
    public static class TimeOutVariable{
        public static final int IMPLICIT_WAIT=20;
        public static final int EXPLICIT_WAIT=10;
        public static final int PAGE_LOAD_WAIT=20;
    }
    public static class Urls{
        public static final String HEROKU_HOME = "https://www.heroku.com/home";
        public static final String BBC_HOME = "https://www.bbc.com/";
    }
    public static class Titles{
        public static final String HEROKU_SIGNIN_TITLE="Heroku | Sign up";
        public static final String BBC_SIGNIN_TITLE="BBC – Sign in";
        public static final String BBC_REGISTER_TITLE="BBC – Register";
    }
    public static class Values{
        public static final String FIRST_NAME=StringModifier.getUniqueString("tuzik");
        public static final String LAST_NAME="zloy";
        public static final String EMAIL="zloytuzikvsehkusaet@gmail.com";
        public static final String COMPANY_NAME="vseh kusat";
        public static final Integer PAUSE=2;

    }
}
