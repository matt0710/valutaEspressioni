import java.util.LinkedList;
import java.util.Stack;

public class Calcolatrice{

    private char[] prova = new char[100];

    public boolean controllaParentesi(String espressione) throws ParentesiErrateException{
        boolean flag = false;
        Stack <Character> pilaParentesi = new Stack<>();
        this.prova = espressione.toCharArray();

        for(int i=0; i<this.prova.length; i++){

            switch(prova[i]){
                case '(':
                    pilaParentesi.push(prova[i]);
                    break;
                case '[':
                    pilaParentesi.push(prova[i]);
                    break;
                case '{':
                    pilaParentesi.push(prova[i]);
                    break;
                case ')':
                    if(pilaParentesi.peek() == '(')
                        pilaParentesi.pop();
                    else
                        throw new ParentesiErrateException();
                    break;
                case ']':
                    if(pilaParentesi.peek() == '[')
                        pilaParentesi.pop();
                    else
                        throw new ParentesiErrateException();
                    break;
                case '}':
                    if(pilaParentesi.peek() == '{')
                        pilaParentesi.pop();
                    else
                        throw new ParentesiErrateException();
                    break;
            }
        }
        if(pilaParentesi.size()==0)
            flag = true;
        return flag;
    }


    public int valutaEspressione(String espressione) throws ParentesiErrateException{

        Stack<Character> nuovaPila = new Stack<>();
        Stack<Character> pila2 = new Stack<>();
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> list2 = new LinkedList<>();
        this.prova = espressione.toCharArray();
        String str = "";
        char carattere = ' ';
        int risultato = 0;

        controllaParentesi(espressione);

        for(int i=0; i<this.prova.length; i++){

            //nuovaPila.push(prova[i]);

            if (prova[i] != ')'){
                nuovaPila.push(prova[i]);
                /*if(prova[i] == '('){
                    pila2.push(nuovaPila.pop());
                }*/
            }
            else{
                while(nuovaPila.peek() != '(')
                    pila2.push(nuovaPila.pop());
                nuovaPila.pop();

                while (!pila2.empty()){
                    list.add(pila2.pop());
                }

                for(int j=0; j<list.size(); j++){
                    if(list.get(j) == '+')
                        risultato += Integer.parseInt(Character.toString(list.get(j-1))) + Integer.parseInt(Character.toString(list.get(j+1)));
                    else if (list.get(j) == '-'){
                        risultato += Integer.parseInt(Character.toString(list.get(j+1))) - Integer.parseInt(Character.toString(list.get(j-1)));
                    }
                }
                nuovaPila.push(Integer.toString(risultato).charAt(0));
                risultato = 0;
                list = new LinkedList<>();

            }
/*
            if(prova[i] ==')' && prova[i+1] != ')' ) {
                if (prova[i+1] == '+') {
                    //risultato += Integer.parseInt(Character.toString(nuovaPila.get(i + 1)));
                    risultato += Integer.parseInt(Character.toString(prova[i + 2]));
                } else if (prova[i+1] == '-')
                    risultato -= Integer.parseInt(Character.toString(prova[i + 2]));
            }*/

        }

        while (!nuovaPila.empty()){
            list2.add(nuovaPila.pop());
        }

        for(int j=0; j<list2.size(); j++){
            if(list2.get(j) == '+')
                risultato += Integer.parseInt(Character.toString(list2.get(j-1))) + Integer.parseInt(Character.toString(list2.get(j+1)));
            else if (list2.get(j) == '-'){
                risultato += Integer.parseInt(Character.toString(list2.get(j+1))) - Integer.parseInt(Character.toString(list2.get(j-1)));
            }
        }
        return risultato;

       // System.out.println(carattere);
    }//se trovo una chiusa prima ci deve essere per forza un'aperta.
    //inizio quindi a fare il pop. Quando torno la parentiesi aperta faccio comunque il pop.
    //man mano che faccio il pop dalla pila 1 faccio il push nella 2 tranne se trovo la parentesi aperta
    //parto poi da pila due e faccio il pop finche non è vuota. Creo una linked list e man mano che faccio il pop inserisco
    //i dati. ciclo sulla lista  e quando trovo l'operatore faccio l'operazione. BISOGNA CONVERTIRE IN INTERI GLI ELEMENTI PRIMA
    //PRIMA DI OPERARE.
    //converto il risultato in un char in modo da fare  il push del risultato in pila1. continuo ad acquisire con pila1 il resto
    //resto dell'espressione.
    //posso ora passare al resto dell'espressione.

}
