package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://skyeng.ru")
    String getBaseUrl();

    @Key("browserSize")
    String getBrowserSize();

    @Key("browserName")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("remote")
    String getRemoteUrl();
}
