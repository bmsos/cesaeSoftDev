document.body.style.background = "grey"
document.getElementById("turma").focus()

let mudarCor = cor => {
    document.body.style.background = cor

    if (cor == "yellow") {
        document.body.style.color = "#333"
    } else if (cor == "blue" || cor == "green") {
        document.body.style.color = "white"
    }
}

