/*
 * Copyright (C) 2014  Secretaria de Orçamento Federal
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package br.gov.siop.rs
import br.gov.siop.rs.receita.RestApplication
import io.undertow.Undertow
import io.undertow.server.handlers.error.SimpleErrorPageHandler
import io.undertow.servlet.api.DeploymentInfo
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.util.concurrent.Executors

class UndertowServer {

    static Logger logger = LoggerFactory.getLogger(UndertowServer)

    static void main(String ... args) {
        Undertow.Builder builder = Undertow.builder()
            .addListener(8080, 'localhost')
            .setHandler(new SimpleErrorPageHandler())

        UndertowJaxrsServer server = new UndertowJaxrsServer()
        server.start(builder)

        DeploymentInfo deployment = server.undertowDeployment(RestApplication)
                .setContextPath('/receita')
                .setDeploymentName('SIOP Receita API')
                .setAsyncExecutor(Executors.newCachedThreadPool())

        server.deploy(deployment)
    }
}
