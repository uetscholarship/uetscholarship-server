package net.bqc.uss.uetnews_server.config;

import net.bqc.uss.service.NotifierService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jcia on 9/28/17.
 */
@Configuration
public class WebserviceConfiguration {

    @Value("${ws.notifier}")
    private String serviceAddress;

    @Bean
    public NotifierService messengerNotifierProxy() {
    	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
    	factory.setServiceClass(NotifierService.class);
    	factory.setAddress(serviceAddress);
    	return (NotifierService) factory.create();
    }
}

