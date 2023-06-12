public class Main {
    public static void main(String[] args){

        FractalGenerator fractalGenerator = new FractalGenerator();
        new FractalDrawing(fractalGenerator);
        new FractalGui(fractalGenerator);

}

    }