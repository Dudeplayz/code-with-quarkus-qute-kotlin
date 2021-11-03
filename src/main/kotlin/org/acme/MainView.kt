package org.acme

import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.page.Push
import com.vaadin.flow.router.Route
import com.vaadin.flow.server.PWA
import com.vaadin.flow.shared.communication.PushMode
import com.vaadin.flow.shared.ui.Transport
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo

@PWA(name = "Betriebstagebuch", shortName = "Bita")
@Theme(value = Lumo::class, variant = Lumo.LIGHT)
@Route(value = "")
@Push(PushMode.AUTOMATIC, transport = Transport.WEBSOCKET_XHR)
class MainView : AppLayout() {
}