using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Model.DataSetLanguageTableAdapters;
using Model.DataSetUserTableAdapters;
using static Model.DataSetAuthor;

namespace Model
{
    public class UserDAO
    {
        // connect to the db
        TabUserTableAdapter tabUserTableAdapter = new TabUserTableAdapter();

        public User ValidateUserName(string userNameInput)
        {
            // execute query and store data in object
            DataSetUser.TabUserDataTable tabUserDataTable = tabUserTableAdapter.ValidateUsername(userNameInput);

            // check if username isn't found
            int dataCount = tabUserDataTable.Count;
            if (dataCount == 0)
            {
                // username not found
                return null;
            }
            else
            {
                // iterate through data storing each row in a new user
                foreach (DataRow row in tabUserDataTable)
                {
                    // check if username in this row matches input username
                    string userName = row["UserName"].ToString();
                    if (userName == userNameInput)
                    {
                        // create user obj of valid username
                        int uid = Convert.ToInt32(row["UID"]);
                        string password = row["Password"].ToString();
                        int userLevel = Convert.ToInt32(row["UserLevel"]);

                        User user = new User();
                        user.UID = uid;
                        user.UserName = userName;
                        user.Password = password;
                        user.UserLevel = userLevel;

                        /* === Not going to use UID and UserLevel in part 1 of this assessment, but it will be useful later ===*/

                        return user;
                    }
                }
                // username not found
                return null;
            }
        }

        public int FindUserIDByName(string usernameInput)
        {
            // execute query
            DataSetUser.TabUserDataTable tabUserDataTable = tabUserTableAdapter.GetUserIDByName(usernameInput);

            // init UID
            int UID = 0;

            // check if there isn't data
            int dataCount = tabUserDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return 0;
            }
            else
            {
                // iterate through data storing each row in a new user (should only be 1)
                foreach (DataRow row in tabUserDataTable)
                {
                    // store user data in correct format in variable
                    UID = Convert.ToInt32(row["UID"]);
                }

                return UID;
            }
        }


        public List<User> GetAllUsers()
        {
            // execute query
            DataSetUser.TabUserDataTable tabUserDataTable = tabUserTableAdapter.GetAllUsers();

            // check if there isn't data
            int dataCount = tabUserDataTable.Count;
            if (dataCount == 0)
            {
                // no data found
                return null;
            }
            else
            {
                // create list of users
                List<User> users = new List<User>();

                // iterate through data storing each row in a new user
                foreach (DataRow row in tabUserDataTable)
                {
                    // store user data in correct format in variables
                    int uid = Convert.ToInt32(row["UID"]);
                    string userName = row["UserName"].ToString();
                    string password = row["Password"].ToString();
                    int userLevel = Convert.ToInt32(row["UserLevel"]);

                    // set user data with created variables
                    User user = new User();
                    user.UID = uid;
                    user.UserName = userName;
                    user.Password = password;
                    user.UserLevel = userLevel;

                    // add user to list
                    users.Add(user);
                }

                return users;
            }
        }

        // CRUD
        public void CreateUser(string username, string password, int userLevel)
        {
            // execute query
            tabUserTableAdapter.CreateUser(username, password, userLevel);
        }

        public void UpdateUser(string username, string password, int userLevel, int userID)
        {
            // execute query
            tabUserTableAdapter.UpdateUser(username, password, userLevel, userID);
        }

        public void DeleteUser(int userID)
        {
            // execute query
            tabUserTableAdapter.DeleteUser(userID);
        }
    }
}
