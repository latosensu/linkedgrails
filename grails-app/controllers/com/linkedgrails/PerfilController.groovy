package com.linkedgrails

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional


@Secured(['ROLE_ADMIN'])
class PerfilController {

    static allowedMethods = [acao5: ["GET", "DELETE"/*, "POST"*/]]


    def perfilService
    def acao1() {
        render "Uma Mensagem"
    }
    @Secured(['ROLE_ACAO2'])
    def acao2(String parametro) {
        render parametro
    }

    def acao3() {
        forward action: "acao1"
    }

    def acao4() {

        render "${params.par1 ?: "Vazio"} ${params.par2} ${params.par3}"
    }

    def acao5() {
//        if (request.method == "GET") {
//            response.status = 405
//        }


    }

    def acao6(){
        render view: "novaPagina", model:[
                dataAtual: new Date(),
                nome: "Bruno"
        ]
    }

    def acao7() {
        render ([Spock: "Sensacional!"] as JSON)


    }

    def acao8() {



//        render ([Spock: "Sensacional!"] as XML)
        render(contentType:"text/xml") {
            Spock(qualidade:"Sensacional!")
        }
    }

    def listarGrupos(Pessoa pessoa){

        ParticipacaoGrupo.findAllByPessoa(pessoa)
                .collect { participacao ->
            participacao.grupo
        }
//        perfilService.listarGruposPessoa()
    }


    @Transactional
    def meuPerfil(Pessoa pessoa222) {


        println "A pessoa é ${pessoa222}"
        //pessoa222.save(flush: true)
//        String nome = "Não existe essa pessoa"
//        if (pessoa){
//            nome = pessoa.nome
//        }
//        render pessoa?pessoa.nome:"Não existe essa pessoa"

        //render pessoa as JSON
        //respond pessoa
//        respond([:], status: 200)

//        respond ([informacao1: "Info 1", pessoaNova: pessoa222,
//                umNumero: 14])

//        redirect(controller:'pessoa',
//                action: 'show', id: pessoa222.id)

        flash.message = "Teste de mensagem flash"
        flash.message1 = "Outra mensagem flash"
        flash.idade = 109

        println "Params: ${params}"


        println "Action name: ${actionName}"
        println "Action uri: ${actionUri}"
        println "Controller name ${controllerName}"
        println "Controller uri ${controllerUri}"
        println "Controller class ${controllerClass}"

        respond(pessoa222, model: [informacao1: "Info 1",
                                   pessoaNova : pessoa222,
                                   umNumero   : 14

        ], status: 303)

//        redirect(controller: "grupo",
//                action: "index")

//        redirect(url: "http://www.ufscar.br")

    }
}
