// exercicio 1
// let nome = "Bruno"
// console.log(nome)

// exercicio2
// let nome = "Bruno"
// let sobrenome = "Oliveira"
// console.log(`Nome completo: ${nome} ${sobrenome}`)


// exercicio3
// let nome = "Bruno"
// let sobrenome = "Oliveira"
// let idade = 34
// let email = "bruno@gmail.com"

// console.log(`
// Nome: ${nome}
// Sobrenome: ${sobrenome}
// Idade: ${idade}
// Email: ${email}
// `)

// exercicio4
// let nome = "Bruno"
// let sobrenome = "Oliveira"
// let idade = 34
// let email = "bruno@gmail.com"

// console.log(`
// Nome: ${nome} (${nome.length})
// Sobrenome: ${sobrenome} (${sobrenome.length})
// Idade: ${idade} (${idade.toString().length})
// Email: ${email} (${email.length})
// `)

// exercicio5
// let nome = "Bruno"
// let sobrenome = "Oliveira"
// console.log(`
// Nome: ${nome.toUpperCase()}
// Sobrenome: ${sobrenome.toLowerCase()}
// `)

// exercicio6
// let p = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente odit aliquam, iusto illum qui enim nemo aliquid ad quod pariatur quo eligendi sequi. Harum voluptas laborum praesentium cumque temporibus eum."
// console.log(p)
// console.log(`Primeira ocorrência da letra a: índice ${p.indexOf("a")}`)
// console.log(`Última ocorrência da letra b: índice ${p.lastIndexOf("b")}`)

// // exercicio7
// let n1, n2
// n1 = 4.4
// n2 = 3
// // number.toFixed(x) - define o numero de decimais a usar por um float
// // number representa o floating point
// // x representa o número de casas decimais a usar
// console.log(`
// n1 = ${n1}
// n2 = ${n2}
// Soma: ${n1 + n2} 
// Subtração: ${(n1 - n2).toFixed(1)}
// Multiplicação: ${(n1 * n2).toFixed(1)}
// Divisão: ${(n1 / n2).toFixed(1)}
// Resto: ${(n1 % n2).toFixed(1)}
// Exponencial: ${(n1 ** n2).toFixed(2)}
// Raiz quadrada de ${n1}: ${Math.sqrt(n1)}
// Valor absoluto de ${n1}: ${Math.floor(n1)}
// `)

// exericio8
// console.log(Math.random())
// console.log("Math.random() retorna um número floating point aleatório entre 0(inclusive) e 1(exclusive)")

// exercicio9
// console.log(Math.random() * 10)

// exercicio10
// let n1 = 5.6901
// let n2 = 4.3264
// console.log(`
// Valores originais:
// n1 = ${n1}
// n2 = ${n2}

// Valores arredondados:
// n1 = ${n1.toFixed(1)}
// n2 = ${n2.toFixed(1)}

// Valor arredondado para baixo (base):
// n1 = ${Math.floor(n1)}
// n2 = ${Math.floor(n2)}

// Valor Valor arredondado para cima (topo):
// n1 = ${Math.ceil(n1)}
// n2 = ${Math.ceil(n2)}
// `)^

// exericio11
// let n = 20
// if (n > 37.5) {
//     console.log("Tem febre")
// } else {
//     console.log("Saudavel")
// }

// exercicio12
// let n = 20
// if (n > 37.5) {
//     console.log("Tem febre")
// } else if (n < 35) {
//     console.log("Temperatura muito baixa")
// } else {
//     console.log("Saudavel")
// }

// exercicio13
// let idade = prompt("Indique a sua idade"), 
// genero = prompt("Indique o seu género (0 - masculino | 1 - feminino)")

// let mensagem1, mensagem2

// if (genero == 0) {
//     if (idade <25) {
//         mensagem1 = "O jovem "
//     } else {
//         mensagem1 = "O Homem "
//     }
// } else if (genero == 1) {
//     if (idade <25) {
//         mensagem1 = "A jovem "
//     } else {
//         mensagem1 = "A Mulher "
//     }
// } else {
//     alert("Género inválido. Indique 0 para masculino e 1 para feminino")
// }

// if (idade < 18) {
//     mensagem2 = "é menor de idade."
// } else {
//     mensagem2 = "é maior de idade."
// }

// if (mensagem1 && mensagem2) {
//     console.log(mensagem1 + mensagem2)
// } else {
//     console.log("Ups! Algo correu mal. Tente novamente.")
// }

// exercicio 14
let n = prompt("Indqiue um número")
