package Ex01;

public class Cao {
    String nome= "Fido";
    String raca = "Boerboel";
    String latido = "wooof!";
    int idade = 6;
    Cao(String nome_temp) {
        this.nome = nome_temp;
    }
    Cao(String nome_temp, String raca_temp, String latido_temp, int idade_temp){
        this.nome = nome_temp;
        this.raca = raca_temp;
        this.latido = latido_temp;
        this.idade = idade_temp;
    }
}