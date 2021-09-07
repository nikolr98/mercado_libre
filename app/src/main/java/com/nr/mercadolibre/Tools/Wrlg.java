package com.nr.mercadolibre.Tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Wrlg {
    public void wrDataTxt(String data){
        String date = getLocalDate(true);
        String time = getLocalDate(false);
        try {
            String carpeta = "/sdcard/logs/debug";
            File dir = new File(carpeta);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String nomarchivo = "debugdataML"+date+".txt";
            File f = new File( carpeta+"/"+nomarchivo);
            if(f.exists()){
                FileReader fr =new FileReader(f);
                try(BufferedReader br = new BufferedReader(fr)) {
                    StringBuilder archivo = new StringBuilder();
                    for(String leer; (leer = br.readLine()) != null; ) {
                        archivo.append(leer);
                        archivo.append("\n");
                    }
                    FileWriter w = new FileWriter(f);
                    BufferedWriter bw = new BufferedWriter(w);
                    bw.write(archivo.toString());
                    bw.append(time).append(" - ").append(data);
                    bw.newLine();
                    br.close();
                    bw.close();
                }

            }else{
                FileWriter w = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(w);
                bw.write("Archivo de Log-Debug para el dia "+date);
                bw.newLine();
                bw.append(time).append(" - ").append(data);
                bw.newLine();
                bw.close();
            }

        }catch (IOException e){
            System.out.println("Fallo "+e);
        }
    }

    private String getLocalDate(boolean b) {
        if (b){
            return DateToStr(new Date(), "MMdd");
        }else
            return DateToStr(new Date(), "HHmmss");

    }

    private String DateToStr(Date date, String formatString) {
        String str = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);// formatString
            str = format.format(date);
        } catch (Exception e) {
        }
        return str;
    }
}
