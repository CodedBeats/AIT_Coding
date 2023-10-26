using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model;
using DTO;

namespace Controller
{
    public class UserController
    {
        public List<UserDTO> GetAllUsers()
        {
            UserLogic userLogic = new UserLogic();
            return userLogic.GetAllUserDTOs();
        }

        public bool ValidateLogin(string userNameInput, string passwordInput)
        {
            UserLogic userLogic = new UserLogic();
            return userLogic.ValidateLogin(userNameInput, passwordInput);
        }
    }
}
