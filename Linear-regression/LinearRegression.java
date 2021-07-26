import java.util.*;
import java.io.*;

public class LinearRegression {
    public static void main(String[] args) throws Exception {
        int n= 5;
        double []x = new double[n];
        double []y = new double[n];

        String filename = "input.txt";
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String[] split;
        int i = 0;

        while((line=br.readLine()) != null){
            split = line.split("\\s+");
            x[i] = Double.parseDouble((split[0]));
            y[i] = Double.parseDouble(split[1]);
            i++;
        }


        double sumx = 0.0; double sumy = 0.0; double sumz=0.0; double sumw=0.0;
        for (i=0; i<n; i++) {
            sumx  = sumx +  x[i];
            sumz = sumz + (x[i] * x[i]);
            sumy  = sumy + y[i];
            sumw = sumw + (x[i] * y[i]);
        }

        double Slopeb = (n*sumw - sumx*sumy) / (n*sumz - sumx * sumx);
        double Intercepta = (sumy-Slopeb*sumx)/ n;

        System.out.println("y = " + Intercepta + " + " + Slopeb + " * x " );

        double newx = 64; double newy = 0.0;
        newy = Intercepta + Slopeb * newx;
        System.out.println("y = " + newy );

    }

}
