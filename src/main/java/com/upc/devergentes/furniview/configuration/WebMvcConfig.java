package com.upc.devergentes.furniview.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebMvcConfig{

    /*
    *configura un filtro para forzar la codificación UTF-8 en las solicitudes y respuestas.
    *Esto lo hago para que los caracteres especiales sean interpretados mostrados correctamente en la appweb
    * de modo en que agrego al menos una configuración extra además del enableWebMvc, que me permite el paso de los archivos
    * */

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
