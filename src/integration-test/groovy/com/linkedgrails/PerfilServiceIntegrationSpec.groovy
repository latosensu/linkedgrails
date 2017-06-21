package com.linkedgrails


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class PerfilServiceIntegrationSpec extends Specification {

    def perfilService

    @Shared
    Pessoa pessoa

    def setup() {
        pessoa = new Pessoa(nome: "João", idade: 42,
                dataNascimento: new Date(),
                estadoCivil: "Solteiro").
                save(flush: true, failOnError: true)
    }

    def cleanup() {
    }

    void "Listar grupos de pessoa sem grupos"() {
        when: "Lista os grupos da pessoa"
        def grupos = perfilService.listarGruposPessoa(pessoa)
        then: "A lista é vazia"
        grupos.empty
    }

    void "Listar grupos de pessoa com 1 grupo"() {
        setup:
        def grupoGrails = new Grupo(nome: "Grails")
                .save(flush: true, failOnError:true)

        def participacao = new ParticipacaoGrupo(
                pessoa: pessoa, grupo: grupoGrails
        ).save(flush: true, failOnError: true)

        when: "Lista os grupos da pessoa"
        def grupos = perfilService.listarGruposPessoa(pessoa)

        then: "A lista tem tamanho 1"
        grupos.size()==1
    }
}
