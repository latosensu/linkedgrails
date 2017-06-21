<html>
<body>
Olá ${pessoa.nome}!!


<g:form action="meuPerfil" id="${pessoa.id}">
    Nome <g:textField name="nome" value="${pessoa.nome}"/>
    Idade <input type="text" name="idade" value="${flash.idade}" id="idade" />

    Data nascimento <g:datePicker name="dataNascimento" value="${pessoa.dataNascimento}"/>
    TextArea <g:textArea name="textArea" />
    <g:submitButton name="Enviar"/>


</g:form>



</body>
</html>