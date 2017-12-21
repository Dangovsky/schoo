import dao.ApprenticeDao;
import entity.ApprenticeEntity;

import java.util.List;

public class Main {

    public static void main(final String[] args) throws Exception {

        ApprenticeDao f = new ApprenticeDao();
        //f.Add(4,3, Time.valueOf("12:00:00"));
        //f.Add(4,3, Time.valueOf("10:00:00"));
        List<ApprenticeEntity> a = f.getAll();
        //a = f.getById(4,3, Time.valueOf("10:00:00"));
        a.get(1).setContactNumber(455454);
        f.Update(a.get(1).getId(),a.get(1).getName(), a.get(1).getContactNumber(), null);
        List<ApprenticeEntity> b = f.getAll();
        //f.Delete(4,3, Time.valueOf("10:00:00"));
        System.out.println("lel");
    }
}