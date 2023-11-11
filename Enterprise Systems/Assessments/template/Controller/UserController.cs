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
        UserLogic userLogic = new UserLogic();

        public UserType ValidateLogin(string userNameInput, string passwordInput)
        {
            return userLogic.ValidateLogin(userNameInput, passwordInput);
        }
    }
}
