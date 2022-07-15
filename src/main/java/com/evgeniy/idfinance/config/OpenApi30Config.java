package com.evgeniy.idfinance.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "IDFinance API", version = "${api.version}",
                contact = @Contact(name = "Evgeniy Leshevich", email = "evgeniy.leshevich@gmail.com", url = "https://t.me/ah4udo"),
                description = "${api.description}"),
        servers = {
                @Server(url = "http://localhost:${server.port}", description = "Development")})
public class OpenApi30Config {
}
