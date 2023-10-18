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
            List<User> users = userDAO.GetAllUsers();

            if (users == null)
            {
                return null;
            }

            // Transform User objects into UserDTO objects
            List<UserDTO> userDTOs = users.Select(user => new UserDTO
            {
                UID = user.Uid,
                UserName = user.UserName,
                Password = user.Password,
                UserLevel = user.UserLevel
            }).ToList();

            return userDTOs;
        }
    }
}
