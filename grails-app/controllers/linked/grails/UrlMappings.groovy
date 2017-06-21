package linked.grails

class UrlMappings {

    static mappings = {

        "/meuPerfil/$id(.$format)?"(
                controller: 'perfil',
                action: 'meuPerfil'
        )


        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')


    }
}
