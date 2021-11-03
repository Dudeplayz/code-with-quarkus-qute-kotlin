package org.acme

import io.vertx.core.Vertx

fun main() {
    Vertx.vertx().deployVerticle(UIVerticle())
}