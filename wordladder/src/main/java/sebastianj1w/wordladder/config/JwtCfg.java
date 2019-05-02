package sebastianj1w.wordladder.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sebastianj1w.wordladder.filter.JwtFilter;

@Configuration
public class JwtCfg {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/word_ladder/*");

        return registrationBean;
    }

}