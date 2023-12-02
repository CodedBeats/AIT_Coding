using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class UserLogic
    {
        UserDAO userDAO = new UserDAO();

        public List<User> GetAllUsers()
        {
            UserDAO userDAO = new UserDAO();
            // create list of users
            List<User> users = userDAO.GetAllUsers();

            return users;
        }
    }
}
