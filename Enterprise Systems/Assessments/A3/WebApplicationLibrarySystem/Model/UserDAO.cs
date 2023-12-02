using System;
using System.Collections.Generic;
using System.Linq;
using System.Data;
using System.Text;
using System.Threading.Tasks;
using Model.DataSetUserTableAdapters;

namespace Model
{
    public class UserDAO
    {
        // connect to the db
        TabUserTableAdapter tabUserTableAdapter = new TabUserTableAdapter();

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
    }
}
