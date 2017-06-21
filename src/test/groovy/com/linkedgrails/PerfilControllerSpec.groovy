package com.linkedgrails

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PerfilController)
class PerfilControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Action acao1 retorna texto 'Uma Mensagem'"() {

        when: "Chamar a ação 1"
        controller.acao1()

        then: "Retorna o texto 'Uma Mensagem'"
        response.text == "Uma Mensagem"

    }


    @Unroll
    void "Action acao2 quando passa #parametro retorna #parametro"() {

        when: "Chama a acao2 com um parametro"
        controller.acao2(parametro)
        then: "Retorna o próprio parâmetro"
        response.text == parametro

        where:
        parametro    | saida
        "Grails"     | "Grails"
        "parametro2" | "parametro"
//        parametro << ["Grails", "parametro2"]
    }


    def "Action acao3 redireciona para acao1"() {

        when: "Chama a acao 3"
        controller.acao3()

        then: "É redirecionado para a acao1"
//        response.redirectedUrl == "/perfil/acao1"
        response.forwardedUrl == "/perfil/acao1"
    }

    @Unroll
    def "Action acao4 com parametros XL, #par2, #par3 retorna #saida"() {
        when: "Chama a acao 4 passando parâmetros"
        params.par1 = par1
        params.par2 = par2
        params.par3 = par3
        controller.acao4()

        then: "Retorna um texto com os parâmetros concatenados"
        response.text == saida

        where:
        par1 | par2   | par3   || saida
        "Oi" | "tudo" | "bem?" || "Oi tudo bem?"
        null | "tudo" | "bem?" || "Vazio tudo bem?"
    }

    def "Bloquear chamadas POST para método acao5"() {

        when: "Chamar o acao5 com POST"
        request.method = "POST"
        controller.acao5()

        then: "Deverá retornar código 405"
        response.status == 405
    }

    def "A acao 6 renderiza a view novaPagina com model específico"() {
        when: "Chamar a acao 6"
        controller.acao6()

        then: "A view será a novaPagina"
        view == "/perfil/novaPagina"

        and: "O model é igual o esperado"
        model.nome == "Bruno"
        model.dataAtual != null
    }

    def "A acao7 renderiza o JSON corretamente"() {
        when: "Chamar a acao7"
        controller.acao7()

        then: "O JSON gerado é igual o esperado"
        response.text == '{"Spock":"Sensacional!"}'

        response.json.Spock == "Sensacional!"
    }

    def "A acao8 renderiza o XML corretamente"() {
        when: "Chamar a acao7"
        controller.acao8()
        println response.text
        then: "O XML gerado é igual o esperado"
//        response.text == '{"Spock":"Sensacional!"}'
//
        response.xml.@qualidade.text() == "Sensacional!"
    }
}
