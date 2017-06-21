package com.linkedgrails

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.validation.ValidationException
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(PerfilService)
@Mock([Pessoa, Experiencia,
        ExperienciaProfissional, ParticipacaoGrupo])
class PerfilServiceSpec extends Specification {


    @Shared
    Pessoa pessoa

    @Shared
    Map mapa

    @Shared
    ExperienciaProfissional experiencia

//    static doWithSpring = {
//        grupoService(GrupoService)
//    }


    def setup() {
        pessoa = new Pessoa(
                nome: "Marcos", dataNascimento: new Date(),
                estadoCivil: "Casado", idade: 0
        ).save(failOnError: true, flush: true)

        experiencia = new ExperienciaProfissional(
                nivel: "Estagiário", descricao: "a",
                nome: "Empresa X", inicio: new Date() - 7,
                fim: new Date())
    }

    def setupSpec() {
        mapa = [grails: "Spock"]

//        mockService(GrupoService)
    }

    def cleanup() {
    }

    def cleanupSpec() {

    }

    void """Adicionar experiência profissional
            válida para pessoa"""() {
        when: "Cadastra uma nova experiência para a pessoa"
        println "Mapa no adicionar experiencia: ${mapa}"
        println "Pessoa no adicionar experiencia: ${pessoa}"
        pessoa.idade = 60
        pessoa.save(flush: true)
        mapa.teste = "1"
        service.cadastrarExperienciaProfissional(pessoa, experiencia)

        then: "A pessoa passa a ter essa experiência"
        ExperienciaProfissional.
                findByPessoa(pessoa).id == experiencia.id
    }

    void """Remover experiência profissional da pessoa"""() {
        setup: "Associa uma experiencia profissional"
        println "Mapa no remover experiencia: ${mapa}"
        println "Pessoa no remover experiencia: ${pessoa}"
        experiencia.pessoa = pessoa
        experiencia.save(flush: true, failOnError: true)

        when: "Removemos uma experiencia"
        service.removerExperiencia(pessoa, experiencia)

        then: "A pessoa não tem mais a experiência"
        ExperienciaProfissional.findByPessoa(pessoa) == null
    }


    void """Adicionar experiencia profissional inválida para
            pessoa lança exceção"""() {
        given: "Uma nova experiencia invalida"
        def experienciaInvalida = new ExperienciaProfissional()

        when: ""
        def retorno = service.cadastrarExperienciaProfissional(
                pessoa, experienciaInvalida
        )

        println "O retorno é: ${retorno}"

        then: "É lançada uma exceção"
        def excecao = thrown(ValidationException)
        excecao.message.startsWith("Experiencia inválida")

    }

//    @Ignore(value = "Ignorado porque não temos o mock do service")
    void "Listar grupos de pessoa sem grupos retorna lista vazia"() {
        when: "Lista os grupos da pessoa"
        def grupos = service.listarGruposPessoa(pessoa)

        then: "A lista é vazia"
        grupos.empty
    }

//    @IgnoreRest
    void "Listar grupos de pessoa com 2 grupos retorna lista com tamanho 2"() {
//        setup: "2 grupos cadastrados"
//        def grupo1 = new Grupo(...).
//                save(flush: true, failOnError: true)
//        def grupo2 = new Grupo(...).
//                save(flush: true, failOnError: true)
//
//        and: "2 participacoes de grupo"
//        def participacao1 =
//                new ParticipacaoGrupo(
//                        pessoa: pessoa, grupo: grupo1
//                ).save()
//
//        def participacao2 =
//                new ParticipacaoGrupo(
//                        pessoa: pessoa, grupo: grupo2
//                ).save()


        setup:
        def grupoServiceMock = Mock(GrupoService)

        grupoServiceMock.
                listarGrupos(pessoa) >> [new Grupo(), new Grupo(), new Grupo()]

        service.grupoService = grupoServiceMock


        when: "Lista os grupos da pessoa"
        def grupos = service.listarGruposPessoa(pessoa)

        then: "A lista tem tamanho 2"
        grupos.size() == 2
    }
}


