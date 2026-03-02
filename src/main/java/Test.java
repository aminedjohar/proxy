import proxy.ProxyCache;
import proxy.SecuredProxy;
import services.IService;
import services.ServiceImpl;

public class Test {
    public static void main(String[] args) {
        System.out.println("--- Appel direct au Service ---");
        IService service = new ServiceImpl();
        System.out.println("Résultat direct : " + service.compute(200));

        System.out.println("\n--- Appel via ProxyCache ---");
        IService cache = new ProxyCache();
        System.out.println("1er appel : " + cache.compute(200));
        System.out.println("2ème appel : " + cache.compute(200));

        System.out.println("\n--- Appel via SecuredProxy ---");
        IService secured = new SecuredProxy("ADMIN");
        System.out.println("ADMIN : " + secured.compute(200));

        IService blocked = new SecuredProxy("GUEST");
        System.out.println("GUEST : " + blocked.compute(200));
    }
}