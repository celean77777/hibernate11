import com.celean.crud.FactoryInit;
import com.celean.crud.Product;
import com.celean.crud.ProductDao;
import org.hibernate.SessionFactory;

import java.util.List;

public class MainApp {
    private static SessionFactory factory;
    public static void main(String[] args) {
        factory= FactoryInit.init();

        ProductDao.saveProduct(factory, new Product("Torch", 560));

        Product product = ProductDao.getProductById(factory, 3L);
        System.out.println(product);

        Product product1 = ProductDao.findProductById(factory, 2L);
        System.out.println(product1);

        ProductDao.deleteProduct(factory, 1L);

        ProductDao.updateProductPrice(factory, 3L, 1345);

        List<Product> productList = ProductDao.findAll(factory);
        productList.forEach(s-> System.out.println(s));

        factory.close();

    }
}
