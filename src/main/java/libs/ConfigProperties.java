package libs;

import org.aeonbits.owner.Config;


@Config.Sources(value = "file:./src/main/resources/config.properties")
public interface ConfigProperties extends Config {
    String base_url();
}
