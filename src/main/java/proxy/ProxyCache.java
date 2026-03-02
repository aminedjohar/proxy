package proxy;

import services.IService;
import services.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ProxyCache implements IService {
    private IService serviceReal;
    private Map<Integer, Double> cache = new HashMap<>();

    public ProxyCache() {
        this.serviceReal = new ServiceImpl();
    }

    @Override
    public double compute(int t) {
        if (cache.containsKey(t)) {
            System.out.println("[CACHE] Résultat trouvé en cache pour t = " + t);
            return cache.get(t);
        }

        System.out.println("[CACHE] Résultat non trouvé, appel au service réel...");
        double result = serviceReal.compute(t);
        cache.put(t, result);
        return result;
    }
}