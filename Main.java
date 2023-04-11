import java.util.Scanner;

public class Main {
    public static String calc(String input) {int a, b, o = 0;
        String g, rso="";
        String[] rmcArray = {"C","I","II","III","IV","V","VI","VII","VIII","IX","X","L"};
        char k;


        g = input;

        if (g.length()<=11) {
            String[] g1 = g.split(" ");

            if (g1.length==3) {

                String ar = g1[0];
                boolean arex = false;
                try {arex = true;
                    Rimc.valueOf(ar);
                } catch (IllegalArgumentException e) {
                    arex = false;
                }
                String br = g1[2];
                boolean brex = false;
                try {brex = true;
                    Rimc.valueOf(br);
                } catch (IllegalArgumentException e) {
                    brex = false;
                }

                if (arex == true && brex == true) {
                    Rimc arm = Rimc.valueOf(g1[0]);
                    Rimc brm = Rimc.valueOf(g1[2]);
                    g1[0] = arm.getArb();
                    g1[2] = brm.getArb();
                    k='r';}
                else { k='a';}

                try {
                    a = Integer.parseInt(g1[0]);
                    b = Integer.parseInt(g1[2]);


                    if (a > -11 && a < 11 && b > -11 && b < 11) {

                        switch (g1[1]) {
                            case "+":
                                o = a + b;
                                break;
                            case "-":
                                o = a - b;
                                break;
                            case "*":
                                o = a * b;
                                break;
                            case "/":
                                o = a / b;
                                break;
                            default:
                                return "throws Exception 0";

                        }
                    } else {
                        return "throws Exception 1";
                    }

                        switch (k) {
                            case 'a':
                                rso = Integer.toString(o);
                                break;
                            case 'r':
                                if (o < 1) {
                                    return "throws Exception //т.к. в римской системе нет отрицательных чисел";
                                } else {
                                    String so = Integer.toString(o);
                                    char[] cifrs = so.toCharArray();
                                    if (cifrs.length == 3) {
                                        rso = rmcArray[0];
                                    } else if (cifrs.length == 2) {
                                        int val1 = Character.getNumericValue(cifrs[0]), val2 = Character.getNumericValue(cifrs[1]);
                                        if (o >= 10 && o < 40) {
                                            for (int i = 0; i < val1; i++) {
                                                rso += rmcArray[10];
                                            }
                                            if (val2 > 0) {
                                                rso += rmcArray[val2];
                                            }
                                        } else if (o == 40) {
                                            rso = "XL";
                                        } else if (o > 40 && o <= 49) {
                                            rso = "XL" + rmcArray[val2];
                                        } else if (o >= 50 && o < 90) {
                                            rso = rmcArray[11];
                                            if (o < 60) {
                                                rso += rmcArray[val2];
                                            } else if (o >= 60 && o < 90) {
                                                val1 -= 5;
                                                for (int i = 0; i < val1; i++) {
                                                    rso += rmcArray[10];
                                                }
                                                if (val2 > 0) {
                                                    rso += rmcArray[val2];
                                                }
                                            }
                                        } else if (o >= 90 && o < 100) {
                                            rso = rmcArray[10] + rmcArray[0];
                                            if (o > 90) {
                                                rso += rmcArray[val2];
                                            }
                                        }
                                    } else if (cifrs.length == 1) {
                                        rso = rmcArray[o];
                                    } else {
                                        return "throws Exception 2";
                                    }



                                }
                                break;

                        }
                }
                catch (NumberFormatException e) {return "throws Exception //т.к. используются одновременно разные системы счисления";}

            } else {return "throws Exception 5";}
        }
        else {return "throws Exception 5";}



        System.out.println("Output:");
        return rso;
    }
    public static void main(String[] args) {
String gg;
        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        gg = in.nextLine();
        in.close();
        System.out.println(calc(gg));

    }
}

