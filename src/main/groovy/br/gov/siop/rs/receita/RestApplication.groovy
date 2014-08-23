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

package br.gov.siop.rs.receita

import br.gov.siop.rs.NotFoundExceptionMapper
import br.gov.siop.rs.receita.cadastro.CenarioResource

import javax.ws.rs.core.Application

class RestApplication extends Application {

    Set<Object> singletons = new HashSet<>()

    Set<Object> classes = new HashSet<>()

    RestApplication() {
        singletons.add new CenarioResource()
        singletons.add new NotFoundExceptionMapper()
    }
}
