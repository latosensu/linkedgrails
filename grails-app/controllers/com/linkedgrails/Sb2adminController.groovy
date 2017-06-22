package com.linkedgrails

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class Sb2adminController {

    def index(String pagina) {
        render view: "/sb2-admin/${pagina}"
    }
}
