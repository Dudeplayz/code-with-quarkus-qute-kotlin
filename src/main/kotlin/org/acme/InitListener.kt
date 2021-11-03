package org.acme

import io.quarkus.runtime.StartupEvent
import io.vertx.core.Vertx
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes

@ApplicationScoped
class VerticleDeployer {

    fun init(@Observes e: StartupEvent, vertx: Vertx, verticle: UIVerticle) {
        vertx.deployVerticle(verticle).onComplete {
            println(it.result())
        }
    }
}
