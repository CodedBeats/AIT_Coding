using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DTO;

namespace Model
{
    public class UserLogic
    {

        // return different numbers for different users
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
                if (user.UserName == "user")
                {
                    return UserType.Student;
                }
                // Staff or admin user
                else if (user.UserName == "sup" || user.UserName == "admin")
                {
                    return UserType.StaffOrAdmin;
                }
            }
            // Input password isn't correct for this username
            return UserType.NoUser;
        }
    }
}
