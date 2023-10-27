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
        public bool ValidateLogin(string userNameInput, string passwordInput)
        {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.ValidateUserName(userNameInput);

            // check user isn't null
            if (user == null)
            {
                return false;
            }
            // check if current user password matches input password
            else if (user.Password == passwordInput)
            {
                return true;
            }
            // input password isn't correct for this username
            else
            {
                return false;
            }
        }
    }
}
