package config

import javax.servlet.ServletContext
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

class WebInitializer extends WebApplicationInitializer {

  def onStartup(servletContext: ServletContext) {
    val root = new AnnotationConfigWebApplicationContext
    root.register(classOf[SpringConfig])
    servletContext.addListener(new ContextLoaderListener(root))

    val ctx = new AnnotationConfigWebApplicationContext()
    ctx.register(classOf[SpringWebConfig])
    val servlet = servletContext.addServlet("scalaServlet", new DispatcherServlet(ctx))
    servlet.setLoadOnStartup(1)
    servlet.addMapping("/")
  }
}
