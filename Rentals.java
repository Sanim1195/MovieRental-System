package Activity2;

import java.time.LocalDate;
import java.util.Date;
/**
 * The rental class acts as a te
 *
 * @author (Sanim Pokhrel)
 * @version (09-05-2022)
 */
public interface Rentals {

        public abstract boolean isOverdue(LocalDate today);
        public abstract int calculateFine(LocalDate today);
        public abstract void rent(Customers p, LocalDate today);
        public abstract void returnRental();


}

