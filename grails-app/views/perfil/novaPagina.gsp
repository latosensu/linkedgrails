<html>
<body>
${nome}
%{--${dataAtual}--}%
%{--<g:textField name="nome" value="${nome}"></g:textField>--}%
<g:formatDate date="${dataAtual}" format="dd/MM/yyyy"/>
<input type="text" name="nome" value="${nome}" id="nome" />
</body>
</html>