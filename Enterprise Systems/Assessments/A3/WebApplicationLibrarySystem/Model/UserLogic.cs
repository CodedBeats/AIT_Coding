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
        public string GetUser(int uid)
        {
            return userDAO.GetUser(uid);
        }
    }
}
