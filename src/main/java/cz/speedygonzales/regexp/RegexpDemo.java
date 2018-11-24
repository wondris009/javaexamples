package cz.speedygonzales.regexp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vondracek
 * @since 25.10.2015 20:45
 */
public class RegexpDemo {

    private static final Logger LOG = LoggerFactory.getLogger(RegexpDemo.class);
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    private static final String USERNAME_1 = "luka4acek";

    public static void main(String[] args) {

        RegexpDemo app = new RegexpDemo();
        boolean usernameOk = app.validate(USERNAME_1, USERNAME_PATTERN);

        app.logResults(InputType.USERNAME, usernameOk);


    }

    public boolean validate(String inputData, String inputPattern) {

        Pattern pattern = Pattern.compile(inputPattern);
        Matcher matcher = pattern.matcher(inputData);
        return matcher.matches();
    }

    public void logResults(InputType type, boolean validationStatus) {

        LOG.info(printStatus(validationStatus, type));
    }

    private String printStatus(boolean status, InputType type) {

        String result = "";

        if (status) {
            result = type.getType() + " is Okay";
        } else {
            result = type.getType() + " is not Okay";
        }

        return result;
    }

    enum InputType {

        PASSWORD("password"), USERNAME("username");

        private String type;

        InputType(String type) {

            this.type = type;
        }

        public String getType() {

            return type;
        }
    }


}
