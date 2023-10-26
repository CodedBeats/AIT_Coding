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
        public List<UserDTO> GetAllUserDTOs()
        {
            UserDAO userDAO = new UserDAO();
            // create list of User type users with UserDAO function
            List<User> users = userDAO.GetAllUsers();

            // check if no users
            if (users == null)
            {
                return null;
            }

            // clone User type users' data into UserDTO type users
            List<UserDTO> userDTOs = users.Select(user => new UserDTO
            {
                UID = user.UID,
                UserName = user.UserName,
                Password = user.Password,
                UserLevel = user.UserLevel
            }).ToList();

            return userDTOs;
        }

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
