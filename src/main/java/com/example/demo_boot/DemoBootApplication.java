package com.example.demo_boot;

import com.example.demo_boot.dao.ExtendedRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class DemoBootApplication {
    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }


    @Bean
    public ServletWebServerFactory getServletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                //super.postProcessContext(context);
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(redirectConnectorHttp());
        return tomcat;
    }

    private Connector redirectConnectorHttp() {
        Connector redirectConnector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        redirectConnector.setScheme("http");
        redirectConnector.setPort(9090);
        redirectConnector.setSecure(false);
        redirectConnector.setRedirectPort(8441);
        return redirectConnector;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoBootApplication.class, args);


    }

}
