using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Controller.ServiceReferenceLibrarySystem;
using DTO;
using UserDTO = DTO.UserDTO;

namespace Controller
{
    public class UserController
    {
        // connect to web service
        WebServiceLibrarySystemSoapClient soapClient = new WebServiceLibrarySystemSoapClient();

        public List<UserDTO> GetAllUsers()
        {
            // create list
            List<UserDTO> userDTOs = new List<UserDTO>();

            Controller.ServiceReferenceLibrarySystem.User[] users = soapClient.GetAllUsers();
            
            foreach (User user in users)
            {
                // create new userDTO
                UserDTO userDTO = new UserDTO();

                // assign values
                userDTO.UID = user.UID;
                userDTO.UserName = user.UserName;
                userDTO.Password = user.Password;
                userDTO.UserLevel = user.UserLevel;

                // add to list
                userDTOs.Add(userDTO);
            }

            return userDTOs;
        }
    }
}
