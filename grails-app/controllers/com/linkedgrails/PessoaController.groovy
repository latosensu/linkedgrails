package com.linkedgrails

import grails.plugin.springsecurity.annotation.Secured

@Secured(["IS_AUTHENTICATED_FULLY"])
class PessoaController {

    static scaffold = Pessoa

}
