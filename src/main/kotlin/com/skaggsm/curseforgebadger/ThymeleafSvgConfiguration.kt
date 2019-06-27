package com.skaggsm.curseforgebadger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.templateresolver.ITemplateResolver

/**
 * Created by Mitchell Skaggs on 6/27/2019.
 */
@Configuration
class ThymeleafSvgConfiguration {
    @Bean
    fun svgTemplateResolver(): ITemplateResolver {
        val resolver = SpringResourceTemplateResolver()

        resolver.prefix = "classpath:/templates/svg/"
        resolver.suffix = ".svg"
        resolver.setTemplateMode("XML")

        return resolver
    }
}
