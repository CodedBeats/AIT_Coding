using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Model
{
    public class UserLogic
    {
        public List<User> GetAllUsers()
        {
            UserDAO userDAO = new UserDAO();
            // create list of users
            List<User> users = userDAO.GetAllUsers();

            return users;
        }


        // return different user types
        public UserType ValidateLogin(string userNameInput, string passwordInput)
        {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.ValidateUserName(userNameInput);

            // No user
            if (user == null)
            {
                return UserType.NoUser;
            }
            // Valid user
            else if (user.Password == passwordInput)
            {
                // Student user
                if (user.UserLevel == 1)
                {
                    return UserType.Student;
                }
                // Staff or admin user
                else if (user.UserLevel == 2 || user.UserLevel == 3)
                {
                    return UserType.StaffOrAdmin;
                }
            }
            // Input password isn't correct for this username
            return UserType.NoUser;
        }
    }
}
