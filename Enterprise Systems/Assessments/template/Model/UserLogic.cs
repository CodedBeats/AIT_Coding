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


        public List<UserDTO> GetAllUsers()
        {
            UserDAO userDAO = new UserDAO();
            // create list of users
            List<User> users = userDAO.GetAllUsers();

            // check if no users
            if (users == null)
            {
                return null;
            }

            // clone users' data into UserDTO type users
            List<UserDTO> userDTOs = users.Select(user => new UserDTO
            {
                UID = user.UID,
                UserName = user.UserName,
                Password = user.Password,
                UserLevel = user.UserLevel
            }).ToList();

            return userDTOs;
        }


        // CRUD
        public void CreateUser(string username, string password, int userLevel)
        {
            UserDAO userDAO = new UserDAO();
            userDAO.CreateUser(username, password, userLevel);
        }
        
        public void UpdateUser(string username, string password, int userLevel, int userID)
        {
            UserDAO userDAO = new UserDAO();
            userDAO.UpdateUser(username, password, userLevel, userID);
        }

        public void DeleteUser(int userID)
        {
            UserDAO userDAO = new UserDAO();
            userDAO.DeleteUser(userID);
        }
    }
}
