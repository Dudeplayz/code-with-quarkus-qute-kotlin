package org.acme

import io.quarkus.qute.Template
import io.quarkus.qute.TemplateInstance
import java.util.concurrent.CompletionStage
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam

@Path("/template")
class TemplateResource {

    @Inject
    lateinit var hello : Template

    @GET
    fun get(@QueryParam("name") name : String) : CompletionStage<String> {
        return hello.data("name", "test").renderAsync()
    }

}