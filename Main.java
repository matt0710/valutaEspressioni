public class Main {

    public static void main(String[] args){
        Calcolatrice calcolatrice = new Calcolatrice();

        String espressione = "{1+[2+(3)]}";
        String espressione2 = "()";
        String espressione3 = "{20 + [55}+7]";
        String espressione4 = "{+10} + {7+[4*(5+7)]+ (8*7)} + (5/9)";
        String espressione5 = "(2+3)+5";
        String espressione6 = "(2+3)-4";
        String espressione7 = "(2+3)+(1+3)";

        try {
            //calcolatrice.controllaParentesi(espressione4);
            //calcolatrice.valutaEspressione(espressione);
            //System.out.println(calcolatrice.valutaEspressione(espressione5));
            System.out.println("\n" + calcolatrice.valutaEspressione(espressione6));
            System.out.println("\n" + calcolatrice.valutaEspressione(espressione7));
        }catch(ParentesiErrateException PE){}


        //System.out.println();
    }
}
