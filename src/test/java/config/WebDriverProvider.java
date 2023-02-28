package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void setConfig() {

        Configuration.baseUrl = WebDriverProvider.config.getBaseUrl();
        Configuration.browser = WebDriverProvider.config.getBrowserName();
        Configuration.browserVersion = WebDriverProvider.config.getBrowserVersion();
        Configuration.browserSize = WebDriverProvider.config.getBrowserSize();
        String remoteUrl = WebDriverProvider.config.getRemoteUrl();
        if (remoteUrl != null) {
            Configuration.remote = remoteUrl;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
    }
}

