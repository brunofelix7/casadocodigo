package br.com.caelum.casadocodigo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import br.com.caelum.casadocodigo.controller.HomeController;
import br.com.caelum.casadocodigo.dao.ProdutoDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class})
public class AppWebConfiguration {

   /**
    * O @Bean significa que essa classe ou método será gerenciado pelo Spring
    */
   @Bean
   public InternalResourceViewResolver internalResourceViewResolver(){
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
   
   /**
    * Informa ao Spring onde está o arquivo messages.proporties
    */
   @Bean
   public MessageSource messageSource(){
       ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
       messageSource.setBasename("/WEB-INF/messages");
       messageSource.setDefaultEncoding("UTF-8");
       messageSource.setCacheSeconds(1);
       return messageSource;
   }
   
   /**
    * Configura o formato de data para toda a aplicação
    */
   @Bean
   public FormattingConversionService mvcConversionService(){
	   DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
	   DateFormatterRegistrar registrar = new DateFormatterRegistrar();
	   registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
	   registrar.registerFormatters(conversionService);
	   return conversionService;
   }
}
