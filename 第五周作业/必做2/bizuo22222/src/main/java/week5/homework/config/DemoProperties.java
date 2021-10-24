package week5.homework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "week5.homework")
public class DemoProperties {
    private String name;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
