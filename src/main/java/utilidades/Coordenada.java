package utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordenada {

    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada(String coordenada){
        Pattern compile1 = Pattern.compile("\\(\\d+,");
        Pattern compile2 = Pattern.compile(",\\d+\\)");
        Matcher matcher1 = compile1.matcher(coordenada);
        Matcher matcher2 = compile2.matcher(coordenada);
        while (matcher1.find() && matcher2.find()) {
            String group1 = matcher1.group();
            String group2 = matcher2.group();

            this.x = Integer.parseInt(group1.substring(1, group1.length() - 1 ));
            this.y = Integer.parseInt(group2.substring(1, group2.length() - 1 ));
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString(){
        return "("+getX()+","+getY()+")";
    }
    public boolean equals(Object obj) {
        if (obj instanceof Coordenada) {
            return ((Coordenada) obj).getX()==getX() && ((Coordenada) obj).getY()==getY();
        }
        return false;
    }
}
