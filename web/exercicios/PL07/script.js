let apresentarLorem = document.getElementById('apresentarLorem'),
toggleParteLorem = document.getElementById('toggleParteLorem'),
textoLorem = document.getElementById('textoLorem'),
parteLorem = document.getElementById('parteLorem'),
aumentarTexto = document.getElementById('aumentarTexto'),
diminuirTexto = document.getElementById('diminuirTexto')

let mudarCor = cor => {
    document.body.style.background = cor

    if (cor == "yellow") {
        document.body.style.color = "#333"
    } else if (cor == "blue" || cor == "green") {
        document.body.style.color = "white"
    }
}

apresentarLorem.addEventListener ('click', () => {
    if (apresentarLorem.innerHTML == "Mostrar texto") {
        textoLorem.style.display = 'block'
        toggleParteLorem.style.display = "inline"
        aumentarTexto.style.display = "inline"
        diminuirTexto.style.display = "inline"
    } else if (apresentarLorem.innerHTML == "Esconder texto") {
        textoLorem.style.display = 'none'
        toggleParteLorem.style.display = "none"
        aumentarTexto.style.display = "none"
        diminuirTexto.style.display = "none"
    }
    
    apresentarLorem.innerHTML = apresentarLorem.innerHTML == "Mostrar texto" ? "Esconder texto" : "Mostrar texto"
})

toggleParteLorem.addEventListener('click', () => {
    if (toggleParteLorem.innerHTML == "Mostrar parte") {
        parteLorem.style.display = "inline"
    } else if (toggleParteLorem.innerHTML == "Esconder parte") {
        parteLorem.style.display = "none"
    }

    toggleParteLorem.innerHTML = toggleParteLorem.innerHTML == "Esconder parte" ? "Mostrar parte" : "Esconder parte"
})


aumentarTexto.addEventListener('click', () => {
    fontSize = parseInt(textoLorem.style.fontSize.split('px')[0]) + 2
    textoLorem.style.fontSize = `${fontSize}px`
    textoLorem.style.textAlign = "center"
})

diminuirTexto.addEventListener('click', () => {
    fontSize = parseInt(textoLorem.style.fontSize.split('px')[0]) - 2
    textoLorem.style.fontSize = `${fontSize}px`
    textoLorem.style.textAlign = "right"
})
