package spring.yuriygundiuc.librarie.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MySpringMvcDispatcherServletIntitialiizer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringConfig.class }; // Главная конфигурация
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null; // Обычно достаточно одного класса конфигурации
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Все запросы проходят через DispatcherServlet
    }

    public void onStartup(ServletContext aServletContext) throws ServletException, jakarta.servlet.ServletException {
        super.onStartup((jakarta.servlet.ServletContext) aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                (Filter) new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }

}
