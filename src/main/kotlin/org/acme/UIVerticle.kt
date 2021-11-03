package org.acme

import com.github.mcollovati.vertx.vaadin.VaadinVerticle
import com.github.mcollovati.vertx.vaadin.VertxVaadinService
import io.vertx.core.Promise
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Router
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.jboss.logging.Logger
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class UIVerticle : VaadinVerticle() {

    @ConfigProperty(name = "address", defaultValue = "8081")
    lateinit var port: String

    @Inject
    lateinit var logger : Logger

    override fun start(startFuture: Promise<Void>) {
        logger.info("Start init")
        startFuture.future().onFailure { logger.error(it.cause) }
        super.start(startFuture)
    }

    override fun config(): JsonObject {
        return super.config().put("httpPort", port.toInt())
    }

    override fun serviceInitialized(service: VertxVaadinService, router: Router) {
        super.serviceInitialized(service, router)
        logger.info("Service initialized")
    }
}
