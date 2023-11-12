using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;
using DTO;
using static Model.UserLogic;

namespace Controller
{
    public class UserController
    {
        public UserType ValidateLogin(string userNameInput, string passwordInput)
        {
            UserLogic userLogic = new UserLogic();
            return userLogic.ValidateLogin(userNameInput, passwordInput);
        }

        public List<UserDTO> GetAllUsers()
        {
            UserLogic userLogic = new UserLogic();
            return userLogic.GetAllUsers();
        }

        // CRUD
        public void CreateUser(string username, string password, int userLevel)
        {
            UserLogic userLogic = new UserLogic();
            userLogic.CreateUser(username, password, userLevel);
        }

        public void UpdateUser(string username, string password, int userLevel, int userID)
        {
            UserLogic userLogic = new UserLogic();
            userLogic.UpdateUser(username, password, userLevel, userID);
        }

        public void DeleteUser(int userID)
        {
            UserLogic userLogic = new UserLogic();
            userLogic.DeleteUser(userID);
        }
    }
}
