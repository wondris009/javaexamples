package cz.speedygonzales.mkyong;

/**
 * @author vondracek
 * @since 23.3.15 20:16
 */
public class OpenBrowser {

    public static void main(String[] args) {

        String url = "http://www.google.com";
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        try {

            if (os.indexOf("win") >= 0) {

                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);

            } else if (os.indexOf("mac") >= 0) {

                rt.exec("open " + url);

            } else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {

                String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror", "netscape", "opera", "links", "lynx"};

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < browsers.length; i++) {

                    sb.append((i == 0 ? "" : " || ") + browsers[i] + " \"" + url + "\" ");

                    rt.exec(new String[]{"sh", "-c", sb.toString()});

                }
            } else {
                return;
            }

        } catch (Exception e) {

        }

        return;
    }
}
