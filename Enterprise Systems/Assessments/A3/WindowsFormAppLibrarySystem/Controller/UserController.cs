using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Controller.ServiceReferenceLibrarySystem;
using UserDTO = DTO.UserDTO;
using UserType = DTO.UserType;

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

        public UserType ValidateLogin(string userNameInput, string passwordInput)
        {
            return (UserType)soapClient.ValidateLogin(userNameInput, passwordInput);
        }

        public bool CheckIfUserExists(int UID)
        {
            return soapClient.CheckIfUserExists(UID);
        }


        // CRUD
        public void CreateUser(string username, string password, int userLevel)
        {
            soapClient.CreateUser(username, password, userLevel);
        }

        public void UpdateUser(string username, string password, int userLevel, int userID)
        {
            bool userExists = CheckIfUserExists(userID);

            if (userExists)
            {
                soapClient.UpdateUser(username, password, userLevel, userID);
            }
            else
            {
                throw new UserCRUDException($"User with ID {userID} does not exist.");
            }
        }

        public void DeleteUser(int userID)
        {
            bool userExists = CheckIfUserExists(userID);

            if (userExists)
            {
                soapClient.DeleteUser(userID);
            }
            else
            {
                throw new UserCRUDException($"User with ID {userID} does not exist.");
            }
        }
    }




    // Custom exception for no user
    public class UserCRUDException : Exception
    {
        public UserCRUDException() : base() { }
        public UserCRUDException(string message) : base(message) { }
        public UserCRUDException(string message, Exception innerException) : base(message, innerException) { }
    }
}
