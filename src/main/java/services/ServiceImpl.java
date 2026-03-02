package services;

public class ServiceImpl implements IService {
    @Override
    public double compute(int t) {
        double result = 0;
        for (int i = 0; i < t; i++) {
            result += Math.random();
        }
        System.out.println("Exécution du traitement réel pour t = " + t + " => Résultat : " + result);
        return result;
    }
}