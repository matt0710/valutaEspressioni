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
    }
}
