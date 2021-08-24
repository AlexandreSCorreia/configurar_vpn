>## ConfigurarVPN - 20210824 

Objetivo do desenvolvimento do software é otimizar o processo de exclusão, criação ou atualização da VPN.

## Problema inicial 

Durante o atendimento de vários chamados sobre o tema foi presenciado vários cenários onde a máquina do usuário
pode possuir de uma vpn a três configuradas, que causa uma confusão no usuário por mais que eles mesmos tenham as criado.

## Como é solucionado

A maioria dos chamados é solucionado excluindo as vpns desnecessárias e criando uma nova ou trocando o servidor, 
em alguns casos só recriar a vpn com o mesmo servidor resolve o problema.

## Como o software resolve o problema

O software faz uma varredura na máquina e elimina todas as vpns criadas,
durante esse processo ele faz uma validação verificando os servidores configurados.
assim ele cria apenas uma vpn com um servidor valido.


* Se não tiver nenhuma vpn na máquina o software irá cria uma nova com o servidor padrão
* Se tiver mais de uma vpn o software irá exclui todas e através da validação ele cria apenas 1
dependendo do caso será com o servidor padrao
* Se tiver apenas uma vpn configurada, o software irá excluir a vpn e criar uma com um servidor diferente


## Projeto JavaFX com a linguagem Java

Referência, comandos powershell [Clique Aqui](https://docs.microsoft.com/en-us/powershell/module/vpnclient/add-vpnconnection?view=windowsserver2019-ps)
