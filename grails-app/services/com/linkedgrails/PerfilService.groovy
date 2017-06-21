package com.linkedgrails

import grails.transaction.NotTransactional
import grails.transaction.Transactional
import grails.validation.ValidationException


@Transactional
class PerfilService {

//    PerfilService(GrupoService grupoService){
//        grupoService = grupoService
//    }
    GrupoService grupoService

    def listarGruposPessoa(Pessoa pessoa){
//        def grupoService = new GrupoService()
        return grupoService.listarGrupos(pessoa)


    }

    def cadastrarExperienciaProfissional(
            Pessoa pessoa,
            ExperienciaProfissional experiencia) {
        pessoa.addToExperiencias(experiencia)

        if (experiencia.validate()) {
            pessoa.save(flush: true, failOnError: true)
        }
        else {
            println "Passou por aqui"
            throw new ValidationException(
                    "Experiencia inválida", experiencia.errors)
        }
    }

    def removerExperiencia(
            Pessoa pessoa, ExperienciaProfissional experiencia) {

//        if (
//        ExperienciaProfissional.findByPessoa(pessoa) == experiencia) {
//
//
//            experiencia.delete()
//        }

        pessoa.removeFromExperiencias(experiencia)
        experiencia.delete()
        //flush: true, failOnError: true)
//        pessoa.save(flush: true)
        return true
    }

    @NotTransactional
    def soma (Integer a,Integer b){
        return a + b
    }

    @Transactional(readOnly = true)
    def buscaExperiencias(Pessoa pessoa){
        pessoa.nome="KKK"
        ExperienciaProfissional.findByPessoa(pessoa)

    }
}
