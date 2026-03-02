package controller;

import proxy.ProxyCache;
import proxy.SecuredProxy;
import services.IService;

public class Client {
    public static void main(String[] args) {
        System.out.println("===== Test du Proxy Cache =====");
        IService proxyCache = new ProxyCache();
        System.out.println("Résultat : " + proxyCache.compute(100));
        System.out.println("Résultat (2ème appel) : " + proxyCache.compute(100)); // Depuis le cache

        System.out.println();

        System.out.println("===== Test du Proxy Sécurisé =====");
        IService securedAdmin = new SecuredProxy("ADMIN");
        System.out.println("Résultat ADMIN : " + securedAdmin.compute(50));

        System.out.println();

        IService securedUser = new SecuredProxy("USER");
        System.out.println("Résultat USER : " + securedUser.compute(50));
    }
}