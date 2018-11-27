package org.everest.cosmos.configuration;

import org.everest.cosmos.repository.NebularRepository;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletDispatcher extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                DbConfiguration.class
        };
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{
                MvcConfiguration.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
