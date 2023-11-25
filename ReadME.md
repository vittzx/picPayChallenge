# Fazendo o Desafio de Recrutamento do PicPay de 2018 (ESTUDO).

Repositorio criado com intuido de estudo e pratica de Java Spring Boot e
para isso decidi fazer o desafio para uma vaga back-end junior.

Link do desafio: https://github.com/PicPay/picpay-desafio-backend

## REQUISITOS 

- Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.
STATUS: DONE

- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.
STATUS: DONE

- Lojistas só recebem transferências, não enviam dinheiro para ninguém.
STATUS: DONE

- Validar se o usuário tem saldo antes da transferência.
STATUS: DONE

- Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc).
STATUS: DONE 

- A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.
STATUS: DONE

- No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock para simular o envio (https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6).
STATUS: TO DO

- Este serviço deve ser RESTFul.

- Tratamento de Erros
STATUS: DONE

- DOCUMENTACAO
STATUS: TO DO

