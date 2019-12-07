//201802104044杨轲
package cn.edu.sdjzu.xg.bysj.service;
import cn.edu.sdjzu.xg.bysj.dao.UserDao;
import cn.edu.sdjzu.xg.bysj.domain.User;
import java.sql.SQLException;
import java.util.Collection;
public final class UserService {
    private UserDao userDao = UserDao.getInstance();
    private static UserService userService = new UserService();

    public UserService() {
    }

    public static UserService getInstance(){
        return UserService.userService;
    }

    public Collection<User> getUsers(){
        return userDao.findAll();
    }

    public User getUser(Integer id) throws SQLException {
        return userDao.find(id);
    }

    public User findByUsername(String username) throws SQLException{
        return UserDao.getInstance().findByUsername(username);
    }

    public User login(String username, String password) throws SQLException{
        return UserDao.getInstance().login(username, password);
    }
    public boolean changePassword(User user) throws SQLException{
        return UserDao.getInstance().changePassword(user);
    }
}

