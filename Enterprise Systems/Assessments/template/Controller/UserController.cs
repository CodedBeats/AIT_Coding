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
        public bool ValidateLogin(string userNameInput, string passwordInput)
        {
            UserLogic userLogic = new UserLogic();
            return userLogic.ValidateLogin(userNameInput, passwordInput);
        }
    }
}
