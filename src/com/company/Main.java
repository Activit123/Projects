package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;



public class Main {

    public static boolean proba(){
        int x = 1;
        if( x == 2){
            return true;
        } else {
            return false;
        }
    }
    public static boolean proba2(){
        int x = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        int y;
        if( a>b ){
            if( a>c ){
                y = a;
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) throws IOException {
	// write your code here

        int semn = '■';
        int semn2  =  '\uF0DF';

        System.out.println(semn);
        System.out.println(semn2);
        File f1 = new File("input.txt");
        FileWriter f2 = new FileWriter("output.txt");
        Scanner scanner = new Scanner(f1);
        LinkedList<String> deTradus = new LinkedList<>();
        LinkedList<String> codTradus = new LinkedList<>();
        while (scanner.hasNextLine()){
            deTradus.add(scanner.nextLine());

        }

        int spatiu = 0;
        System.out.println(deTradus);
        for (int i=0;i<deTradus.size();i++){
            String aux = "";
            for(int k=0;k<spatiu;k++){
                aux += "\t";
            }
            if(i+1!=deTradus.size()) {
                if (deTradus.get(i + 1).contains("■")) {
                    spatiu--;
                }
            }
            if(deTradus.get(i).contains("pentru")&&!deTradus.get(i).contains("*)")){

                int dim = deTradus.get(i).length();
                if(deTradus.get(i).contains("execută")){
                    dim -= "executa".length();
                }
                String valoare_init ="";
                String copypt1 = "";
                String valoare_final="";
                aux +="for(";
                for (int j="pentru".length()+deTradus.get(i).indexOf("pentru");j<dim;j++){
                    if(j+1==dim){
                        break;
                    }
                    if(deTradus.get(i).charAt(j+1)=='\uF0DF'){
                        valoare_init+=deTradus.get(i).charAt(j);
                        break;
                    } else {
                        valoare_init+=deTradus.get(i).charAt(j);
                    }
                }
                copypt1=valoare_init;
                valoare_init+="= ";
                for (int j=1+ deTradus.get(i).indexOf('\uF0DF');j<dim;j++) {
                    if(j+1==dim){
                        break;
                    }
                    if(deTradus.get(i).charAt(j+1)==','){
                        valoare_init+=deTradus.get(i).charAt(j);
                        break;
                    } else {
                        valoare_init+=deTradus.get(i).charAt(j);
                    }
                }
                for (int j=1+ deTradus.get(i).indexOf(',');j<dim;j++){
                    if(j+1==dim){
                        valoare_final+= deTradus.get(i).charAt(j) ;
                        break;
                    } else {
                        valoare_final+= deTradus.get(i).charAt(j);
                    }

                }
                aux+=valoare_init + "; " + copypt1 + "<" + valoare_final + "; " + copypt1 + "++ ){";
                spatiu++;
                codTradus.add(aux);
                continue;

            }
            if(deTradus.get(i).contains("scrie")) {
                int dim = deTradus.get(i).length();
                boolean ghilimele = false;
                aux += "System.out.println(";
                System.out.println(deTradus.get(i));
                for (int j = "scrie".length()  +deTradus.get(i).indexOf("scrie") ; j < dim; j++) {
                    System.out.println(deTradus.get(i).charAt(j));
                    if((j+1!=dim)){
                        if(deTradus.get(i).charAt(j)=='\"'&&(ghilimele!=true)){
                            ghilimele = true;
                            aux+="\"";
                            continue;
                        }
                        if(deTradus.get(i).charAt(j)=='\"'&&(ghilimele!=false)){
                            ghilimele = false;
                            aux+="\" + ";
                            continue;
                        }

                        if ((j - 1 != 4)&& (deTradus.get(i).charAt(j)==',')) {
                            if(ghilimele==true){
                                aux+= deTradus.get(i).charAt(j) ;
                            } else {
                                aux+=" + ";
                            }

                        } else {
                            aux +=deTradus.get(i).charAt(j);
                        }
                    } else {
                        aux += deTradus.get(i).charAt(j);
                    }
                }
                aux+=" );";
                codTradus.add(aux);
                continue;
            }
            if(deTradus.get(i).contains("procedură")&&!deTradus.get(i).contains("sf.")){
                int dim = deTradus.get(i).length();
                aux += "public static void ";
                for (int j="proocedură".length();j<dim;j++){
                    if(j+1==dim){
                        aux += "){";
                    } else {
                        aux += deTradus.get(i).charAt(j);
                    }
                }
                spatiu++;
                codTradus.add(aux);
                continue;
            }


            if(deTradus.get(i).contains("repetă")){
                aux+="do{";
                codTradus.add(aux);
                spatiu++;
                continue;
            }

            if(deTradus.get(i).contains("cât timp")&& !deTradus.get(i).contains("execută")&& !deTradus.get(i).contains("sf.")){
                int dim = deTradus.get(i).length();
                aux += "}while( ";

                for (int j = "cât timp".length() +  deTradus.get(i).indexOf("cât timp");j<dim;j++){


                    if(deTradus.get(i).charAt(j)=='ş'){
                        System.out.println(true);
                        if(deTradus.get(i).charAt(j+1)=='i'){
                            System.out.println(true);
                            aux+="&&";
                            j++;
                            continue;
                        }
                    }



                    if(j+1==dim){
                        aux += " )";
                    } else {
                        aux+=deTradus.get(i).charAt(j);
                    }

                }
                aux+=";";
                codTradus.add(aux);
                spatiu--;
                continue;

            }
            if(deTradus.get(i).contains("cât timp")&& deTradus.get(i).contains("execută")&&!deTradus.get(i).contains("sf.")){
                int dim = deTradus.get(i).length() -"execută".length();

                aux += "while( ";

                for (int j = "cât timp".length() +  deTradus.get(i).indexOf("cât timp");j<dim;j++){


                    if(deTradus.get(i).charAt(j)=='ş'){
                        System.out.println(true);
                        if(deTradus.get(i).charAt(j+1)=='i'){
                            System.out.println(true);
                            aux+="&&";
                            j++;
                            continue;
                        }
                    }



                    if(j+1==dim){
                        aux += " ){";
                    } else {
                        aux+=deTradus.get(i).charAt(j);
                    }

                }
                codTradus.add(aux);
                spatiu++;
                continue;
            }
            if(deTradus.get(i).contains("int")){

                int dim  =  deTradus.get(i).length();

                for(int j=0;j<dim;j++){
                    if(deTradus.get(i).charAt(j) ==  '\uF0DF'){
                        aux += "=";
                        continue;
                    }
                    if(j+1==dim){
                        aux +=deTradus.get(i).charAt(j)+";";
                    } else {
                        aux += deTradus.get(i).charAt(j);
                    }
                }
                codTradus.add(aux);
                continue;
            }
            if(deTradus.get(i).contains("daca")&&!deTradus.get(i).contains("sf.")){
                int dim = deTradus.get(i).length()-"atunci".length();
                aux += "if(";
                int confirm = 0;

                for (int j="daca".length() + deTradus.get(i).indexOf("daca");j<dim;j++){
                    if(j+1==dim){
                        aux +=deTradus.get(i).charAt(j)+"){";
                    } else {
                        aux += deTradus.get(i).charAt(j);
                    }
                }
                codTradus.add(aux);
                spatiu++;
                continue;

            }

            if(deTradus.get(i).contains("dacă")&&!deTradus.get(i).contains("sf.")){
                int dim = deTradus.get(i).length()-"atunci".length();
                aux += "if(";
                int confirm = 0;

                for (int j="dacă".length() + deTradus.get(i).indexOf("dacă");j<dim;j++){
                    if(j+1==dim){
                        aux +=deTradus.get(i).charAt(j)+"){";
                    } else {
                        aux += deTradus.get(i).charAt(j);
                    }
                }
                codTradus.add(aux);
                spatiu++;
                continue;

            }
            if(deTradus.get(i).contains("returneaza") || deTradus.get(i).contains("întoarce")){
                int dim  = deTradus.get(i).length();
                aux +="return";
                int j = 0;
                if(deTradus.get(i).contains("întoarce")) {
                    j = "întoarce".length()+deTradus.get(i).indexOf("întoarce");
                } else {
                    j = "returneaza".length()+deTradus.get(i).indexOf("returneaza");
                }
                for(;j<dim;j++){
                    if(j+1==dim){
                        aux +=deTradus.get(i).charAt(j)+";";
                    } else {
                        aux += deTradus.get(i).charAt(j);
                    }
                }
                codTradus.add(aux);
                spatiu--;
                continue;
            }

            if(deTradus.get(i).contains("altfel")){

                aux +="} else {";
                codTradus.add(aux);

                continue;

            }

            if(deTradus.get(i).contains("*)")){
                int dim = deTradus.get(i).length();
                aux+="//";
                for (int j  = deTradus.get(i).indexOf("//")+"//".length()+2;j<dim;j++){
                    if(j+1==dim){
                        aux+=deTradus.get(i).charAt(j);
                        break;
                    } else {
                        aux+=deTradus.get(i).charAt(j);
                    }
                }
                codTradus.add(aux);
                continue;
            }

            if(deTradus.get(i).contains("■") ||   deTradus.get(i).contains("sf.procedură") || deTradus.get(i).contains("sf.cât timp") || deTradus.get(i).contains("sf.dacă")){
                aux += "}";
                codTradus.add(aux);
                spatiu--;
                System.out.println(spatiu);
                continue;
            }
            int dim = deTradus.get(i).length();

            for(int j = 0;j<dim;j++){

                if(deTradus.get(i).charAt(j) ==  '\uF0DF'){
                    aux += "=";
                    continue;
                }
                if(j+1==dim){
                    aux +=deTradus.get(i).charAt(j)+";";
                } else {
                    aux += deTradus.get(i).charAt(j);
                }
            }
            codTradus.add(aux);
        }
        System.out.println(codTradus);
        for(int i = 0 ;i<codTradus.size();i++){
            f2.write(codTradus.get(i) + "\n");
        }
        f2.close();
        System.out.println(proba());

    }
}
