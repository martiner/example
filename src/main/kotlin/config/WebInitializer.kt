package config

import javax.servlet.ServletContext
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

public class WebInitializer: WebApplicationInitializer {

    public override fun onStartup(servletContext: ServletContext?) {
        val sc = servletContext!!

        val root = AnnotationConfigWebApplicationContext()
        root.register(javaClass<SpringConfig>())
        sc.addListener(ContextLoaderListener(root));

        val ctx = AnnotationConfigWebApplicationContext()
        ctx.register(javaClass<SpringWebConfig>())
        val servlet = sc.addServlet("appServlet", DispatcherServlet(ctx))!!
        servlet.setLoadOnStartup(1)
        servlet.addMapping("/")

    }
}