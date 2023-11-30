package utils;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LocalDriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private LocalDriverManager() {
    }

    public static WebDriver getInstance() {
        if(driver.get() == null) {
            if (ConfigurationProperties.getConfiguration().getBoolean("run.locally")){
                driver.set(new ChromeDriver());
            }else {
                driver.set(configureRemote());
            }
        } else {
            return driver.get();
        }
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.get().quit();
        driver.remove();
    }
    @SneakyThrows
    public static RemoteWebDriver configureRemote(){
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("107");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-andrikd380-eb868");
        sauceOptions.put("accessKey", "1331ad1b-07ca-4342-b490-65c04cb97794");
        sauceOptions.put("build", "selenium-build-9KOF8");
        sauceOptions.put("name", "<your test name>");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        return new RemoteWebDriver(url, browserOptions);
    }

}
