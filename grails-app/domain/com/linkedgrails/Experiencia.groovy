package com.linkedgrails

abstract class Experiencia {

    String nome
    String descricao
    Pessoa pessoa
    Date inicio
    Date fim

    static belongsTo = [pessoa: Pessoa]

    static constraints = {
        fim nullable: true
    }

    static mapping = {
        //tablePerConcreteClass true
    }
}
