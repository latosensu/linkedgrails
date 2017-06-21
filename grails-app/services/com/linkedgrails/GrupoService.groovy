package com.linkedgrails

import grails.transaction.Transactional
import groovy.sql.Sql

@Transactional
class GrupoService {

    def dataSource

    def dataSource5

    @Transactional(readOnly = true)
    def listarGrupos(Pessoa pessoa) {

        final String query = "SELECT nome, idade FROM PESSOA"
        final Sql sql = new Sql(dataSource)
        def resultados = sql.rows(query)
        resultados


        println "Está dentro do grupoService"
        def grupos = ParticipacaoGrupo.findAllByPessoa(pessoa)
                .collect { participacao ->
                    participacao.grupo
        }
        return grupos
    }
}
