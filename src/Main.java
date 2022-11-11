import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try {
            ProcessBuilder processBuilder= new ProcessBuilder("java","-jar", "librerias/SeparacionExamen.jar");
            Process process = processBuilder.start();
            processBuilder.redirectErrorStream(true);

            //LEE
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            //ESCRIBE
            OutputStream os = process.getOutputStream();
            PrintStream ps = new PrintStream(os);

            System.out.println("DIME UNA FRASE");
            String frase = sc.nextLine();

            //LE PASAMOS LA FRASE AL HIJO
            ps.println(frase);
            ps.flush();

            //LEEMOS LA RESPUESTA
            String palabra;

            while(!((palabra = br.readLine()).isEmpty())){
                System.out.println(palabra);
            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}