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
// let n = prompt("Indique um número")

// if (n == 1) {
//     console.log("Um")
// } else if (n == 2) {
//     console.log("Dois")
// } else if (n == 3) {
//     console.log("Três")
// } else if (n == 4) {
//     console.log("Quatro")
// } else if (n == 5) {
//     console.log("Cinco")
// } else {
//     console.log("Outro valor")
// }


// exercicio15
// let n = parseInt(prompt("Indique um número: "));

// switch (n) {
//     case 1:
//         console.log("Um")
//         break
//     case 2:
//         console.log("Dois")
//         break
//     case 3:
//         console.log("Três")
//         break
//     case 4:
//         console.log("Quatro")
//         break
//     case 5:
//         console.log("Cinco")
//         break
//     default:
//         console.log("Outro valor")
// }

// exercicio16
// let l = Array()
// for (i=1; i<=1000; i++) {
//     l.push(i)
// }
// console.log(l)
// //document.write(l)

// exercicio17
// let l = Array(), i=1
// while (i<=1000) {
//     l.push(i)

//     // a cada 20 nums, break line

//     if (i % 20 == 0) {
//         l.push("\n")
//     }

//     i++
// }
// document.write(l)

// exercicio 18
// let n1 = prompt("Indique o 1º número: "), 
// n2 = prompt("Indique o 2º número: ")

// if (n1 % n2 == 0 && n2 % n1 == 0) {
//     console.log("Um é múltiplo do outro")
// } else if (n1 % n2 == 0 && n2 % n1 != 0) {
//     console.log(`${n1} é múltiplo de ${n2}`)
// } else if (n1 % n2 != 0 && n2 % n1 == 0) {
//     console.log(`${n2} é múltiplo de ${n1}`)
// } else {
//     console.log("Nenhum número é multiplo do outro")
// }

// exercicio 19
// let n = prompt("Numero: ")
// if (n % 2 == 0) {
//     document.write("Par")
// } else {
//     document.write("Impar")
// }

// exercicio 20
// let n = prompt("Numero: ")
// if (n > 99 && n < 1000) {
//     let resto, resultado=0
//     for (i=0; i<3; i++) {
//         resto = n % 10
//         resultado += resto
//         if (i != 2) {
//             resultado *= 10
//         }
//         n = (n - resto) / 10
//     }

//     n = resultado
//     resultado = ""

//     for (i=0; i<3; i++) {
//         resto = n % 10
//         n = (n - resto) / 10 
//         resultado += `${resto} `
//     }

//     console.log(resultado)
// } else {
//     document.write("Não tem 3 digitos")
// }

// exercicio 21
// const n1 = prompt("Numero 1: "), n2 = prompt("Numero 2: "), n3 = prompt("Numero 3: ")
// let menor = n1

// if (n2 < menor && n2 < n3) {
//     menor = n2
// }
// if (n3 < menor) {
//     menor = n3
// }
// console.log(`Menor: ${menor}`)

// exercicio 22
// let temperatura = prompt("Graus Celsius: ")
// console.log(`Graus Fahrenheit: ${temperatura * 1.8 + 32}`)

// exercicio 23
// const v = prompt("Valor em Euros: ")
// let conversaoDolar = v * 1.2, conversaoLibra = v * 0.9, conversaoPeso = v * 28.5

// document.write(`Dólares: ${conversaoDolar}<br>`)
// document.write(`Libras: ${conversaoLibra}<br>`)
// document.write(`Pesos: ${conversaoPeso}`)

// exercicio 24
// let n = prompt("Número"),
// isCapicua = true
// for (i=1; i<=n.length; i++) {
//     if (n[i-1] != n[n.length-i]) {
//         isCapicua = false
//     }
// }
// console.log((isCapicua ? "É capicua" : "Não é capicua"))

// exercicio 25
// let n = prompt("Número: ")

// if (n > 10) {
//     for (i=0; i<=n; i++) {
//         console.log(i)
//     }
// } else {
//     console.log("Número deve ser maior que 10")
// }

// exercicio 26
// let inicio = parseInt(prompt("Inicio do intervalo")),
// fim = parseInt(prompt("Fim do intervalo"))

// for (i=inicio; i<=fim; i++) {
//     if (i % 2 == 0) {
//         console.log(i)
//     }
// }

// exercicio 27
// let v=1;
// while (v % 2 != 0 || v >= 100) {
//     v = prompt("Numero: ")
// }

// for (i=0; i<=v; i++) {
//     if (i % 5 == 0) {
//         document.write(i + "<br>")
//     }
// }