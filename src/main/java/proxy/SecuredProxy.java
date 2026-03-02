package proxy;

import services.IService;
import services.ServiceImpl;

public class SecuredProxy implements IService {
    private IService serviceReal;
    private String role;

    public SecuredProxy(String role) {
        this.serviceReal = new ServiceImpl();
        this.role = role;
    }

    @Override
    public double compute(int t) {
        if ("ADMIN".equals(role)) {
            System.out.println("[SÉCURITÉ] Accès autorisé pour le rôle : " + role);
            return serviceReal.compute(t);
        } else {
            System.out.println("[SÉCURITÉ] Accès refusé pour le rôle : " + role);
            return -1;
        }
    }
}