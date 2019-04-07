class Calculadora{
    int bateria;
    int bateriaMax;

    public Calculadora (int bateria, int bateriaMax){
        this.bateria = bateria;
        this.bateriaMax = bateriaMax;
    }
    public void soma (int a, int b) {
        if (bateria > 0) {
            System.out.println(a + b);
            this.bateria -= 1;
        }else {
            System.out.println("fail: bateria insuficiente");
        }
    }

    public void div (float a, float b) { //usa o void quando não tem retorno
        if (bateria > 0) {
            System.out.println(a / b);
            this.bateria -= 1;
        } else {
            System.out.println("fail: bateria insuficiente");
        }
    }

    public void recarregar (int c) {
        if (c >= this.bateriaMax) {
            this.bateria = this.bateriaMax;
        } else {
            this.bateria += c;
        }
    }
}

public class Controller {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(0, 0);
        Scanner scanner = new Scanner (System.in);
        while (true){
            String line = scanner.nextLine(); // criando uma variável "STRING" que recebe do Scanner a entrada do User.
            String [] ui = line.split(" "); // recebe uma lista de strings que está armazenada em ui. (quebra de linha por espaço)
            if (ui[0].equals("show")) {
                System.out.println(calculadora);
            } else if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("sum")) {
                calculadora.soma(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("div")) {
                calculadora.div(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("charge")) {
                calculadora.recarregar(Integer.parseInt(ui[1]));
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}
